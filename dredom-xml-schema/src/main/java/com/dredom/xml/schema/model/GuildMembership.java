package com.dredom.xml.schema.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Membership in the Guild.
 * @author andre
 *
 */
@XmlType( namespace = "http://dredom/guild", propOrder = {"id", "name"})
@XmlRootElement
public class GuildMembership {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
