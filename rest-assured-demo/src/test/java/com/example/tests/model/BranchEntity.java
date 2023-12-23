package com.example.tests.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchEntity {

    private String name;
    @JsonProperty("_links")
    private Links links;
    private Protection protection;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Links {
        private String html;

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Protection {
        private Boolean enabled;

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Protection getProtection() {
        return protection;
    }

    public void setProtection(Protection protection) {
        this.protection = protection;
    }
}
