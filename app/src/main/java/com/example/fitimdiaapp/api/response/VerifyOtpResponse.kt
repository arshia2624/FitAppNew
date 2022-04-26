package com.example.fitimdiaapp.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.fasterxml.jackson.annotation.JsonAnySetter

import com.fasterxml.jackson.annotation.JsonAnyGetter

import com.fasterxml.jackson.annotation.JsonProperty

import com.fasterxml.jackson.annotation.JsonIgnore




class VerifyOtpResponse {

    @JsonProperty("token")
    private var token: String? = null

    @JsonProperty("type")
    private var type: String? = null

    @JsonProperty("id")
    private var id: String? = null

    @JsonProperty("steps")
    private var steps: Steps? = null

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()

    @JsonProperty("token")
    fun getToken(): String? {
        return token
    }

    @JsonProperty("token")
    fun setToken(token: String?) {
        this.token = token
    }

    @JsonProperty("type")
    fun getType(): String? {
        return type
    }

    @JsonProperty("type")
    fun setType(type: String?) {
        this.type = type
    }

    @JsonProperty("id")
    fun getId(): String? {
        return id
    }

    @JsonProperty("id")
    fun setId(id: String?) {
        this.id = id
    }

    @JsonProperty("steps")
    fun getSteps(): Steps? {
        return steps
    }

    @JsonProperty("steps")
    fun setSteps(steps: Steps?) {
        this.steps = steps
    }

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any>? {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
    class Steps {
        @get:JsonProperty("step1")
        @set:JsonProperty("step1")
        @JsonProperty("step1")
        var step1: Boolean? = null

        @get:JsonProperty("step2")
        @set:JsonProperty("step2")
        @JsonProperty("step2")
        var step2: Boolean? = null

        @get:JsonProperty("step3")
        @set:JsonProperty("step3")
        @JsonProperty("step3")
        var step3: Boolean? = null

        @get:JsonProperty("step4")
        @set:JsonProperty("step4")
        @JsonProperty("step4")
        var step4: Boolean? = null

        @get:JsonProperty("step5")
        @set:JsonProperty("step5")
        @JsonProperty("step5")
        var step5: Boolean? = null

        @JsonIgnore
        private val additionalProperties: MutableMap<String, Any> = HashMap()
        @JsonAnyGetter
        fun getAdditionalProperties(): Map<String, Any> {
            return additionalProperties
        }

        @JsonAnySetter
        fun setAdditionalProperty(name: String, value: Any) {
            additionalProperties[name] = value
        }
    }
}