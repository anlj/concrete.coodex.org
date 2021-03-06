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

package org.coodex.concrete.attachments.repo;

/**
 * Created by davidoff shen on 2016-10-13.
 */
public class FileLocation {
    private String group;
    private String path;

    FileLocation(String group, String path) {
        this.group = group;
        this.path = path;
    }

    public String getGroup() {
        return group;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "FileLocation{" +
                "group='" + group + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
