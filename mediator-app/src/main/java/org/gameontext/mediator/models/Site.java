/*******************************************************************************
 * Copyright (c) 2016 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.gameontext.mediator.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class Site {

    @JsonProperty("_id")
    String id;

    RoomInfo info;
    Exits exits;
    String owner;

    String type;

    public Site() {}

    /**
     * Create a new site using the exit information
     * from a previous site.
     * @param exit
     */
    public Site(Exit exit) {
        this.id = exit.id;
        this.info = new RoomInfo(exit);
        this.exits = new Exits();
    }

    /**
     * Create a new site using the exit information
     * from a previous site, and use the provided fallback
     * exit.
     * @param exit
     */
    public Site(Exit sourceExit, Exits fallbackExits) {
        this.id = sourceExit.id;
        this.info = new RoomInfo(sourceExit);
        this.exits = fallbackExits;
    }

    public Site(String id) {
        this.id = id;
    }

    public RoomInfo getInfo() {
        return info;
    }

    public void setInfo(RoomInfo roomInfo) {
        this.info = roomInfo;
    }

    public Exits getExits() {
        return exits;
    }

    public void setExits(Exits exits) {
        this.exits = exits;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
