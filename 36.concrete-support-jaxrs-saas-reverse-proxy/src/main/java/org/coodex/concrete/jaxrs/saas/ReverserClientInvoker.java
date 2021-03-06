/*
 * Copyright (c) 2017 coodex.org (jujus.shen@126.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.coodex.concrete.jaxrs.saas;

import org.coodex.concrete.jaxrs.client.AbstractRemoteInvoker;
import org.coodex.concrete.jaxrs.struct.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 使用jaxrs 2.0 client
 * Created by davidoff shen on 2017-03-22.
 */
public class ReverserClientInvoker extends AbstractRemoteInvoker {

    private final static Logger log = LoggerFactory.getLogger(ReverserClientInvoker.class);


    private static final Client CLIENT = ClientBuilder.newClient();

    public ReverserClientInvoker(String domain) {
        super(domain);
    }


    private Invocation.Builder setHeaders(Invocation.Builder builder) {
        return builder.headers(DeliveryContext.getContext().getRequestHeaders());
    }

    @Override
    protected Object invoke(String path, Unit unit, Object toSubmit) {
        log.debug("invoke: domain[{}] path[{}]", domain, path);
        Invocation.Builder builder = CLIENT.target(path).request();
        builder = setHeaders(builder);
        return delivery(execute(builder, unit, toSubmit));
    }

    private AsyncResponse getAsyncResponse() {
        return DeliveryContext.getContext().getResponse();
    }

    private Response copy(Response response) {
        // TODO: 待验证是否可行
        return response;
    }

    private Object delivery(Response response) {
        AsyncResponse asyncResponse = getAsyncResponse();
        asyncResponse.resume(copy(response));
        return null;
    }


    private Response execute(Invocation.Builder builder, Unit unit, Object toSubmit) {
        String method = unit.getInvokeType();
        Invocation invocation =
                toSubmit == null ?
                        builder.build(method) :
                        builder.build(method, Entity.entity(toSubmit, MediaType.APPLICATION_JSON));
        return invocation.invoke();
    }
}
