/*
 * Copyright 2018 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package io.reactiverse.es4x.graal.runtime;

import io.netty.util.CharsetUtil;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

final class JSObjectMessageCodec<T> implements MessageCodec<T, Object> {

  private final Value stringify;

  private final Value isObject;
  private final Value isArray;

  JSObjectMessageCodec(Value JSON, Context ctx) {
    this.stringify = JSON.getMember("stringify");

    this.isObject = ctx.eval("js", "function (obj) { return typeof obj === 'object'; }");
    this.isArray = ctx.eval("js", "function () { return Array.isArray; }").execute();
  }

  @Override
  public void encodeToWire(Buffer buffer, T jsObject) {
    String strJson = stringify.execute(jsObject).asString();
    byte[] encoded = strJson.getBytes(CharsetUtil.UTF_8);
    buffer.appendInt(encoded.length);
    Buffer buff = Buffer.buffer(encoded);
    buffer.appendBuffer(buff);
  }

  @Override
  public JsonObject decodeFromWire(int pos, Buffer buffer) {
    int length = buffer.getInt(pos);
    pos += 4;
    byte[] encoded = buffer.getBytes(pos, pos + length);
    String str = new String(encoded, CharsetUtil.UTF_8);
    return new JsonObject(str);
  }

  @Override
  public Object transform(T jsObject) {
    if (isObject.execute(jsObject).asBoolean()) {
      if (isArray.execute(jsObject).asBoolean()) {
        return new JsonArray();
      } else {
        return new JsonObject();
      }
    }
    // cannot cast return as is...
    return jsObject;
  }

  @Override
  public String name() {
    return this.getClass().getSimpleName();
  }

  @Override
  public byte systemCodecID() {
    return -1;
  }
}
