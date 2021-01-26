/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.*;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Eric Zhao
 * @since 1.4.0
 */
@Configuration
public class NacosConfig {

    @Value("${nacos.url:localhost:8848}")
    private String nacosUrl;

    /**
     * 配置流控规则Encoder。
     *
     * @return Converter<List < FlowRuleEntity>, String>
     */
    @Bean
    public Converter<List<FlowRuleEntity>, String> flowRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    /**
     * 配置流控规则Decoder。
     *
     * @return Converter<String, List < FlowRuleEntity>>
     */
    @Bean
    public Converter<String, List<FlowRuleEntity>> flowRuleEntityDecoder() {
        return s -> JSON.parseArray(s, FlowRuleEntity.class);
    }

    /**
     * 配置降级规则Encoder。
     *
     * @return Converter<List < DegradeRuleEntity>, String>
     */
    @Bean
    public Converter<List<DegradeRuleEntity>, String> degradeRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    /**
     * 配置降级规则Decoder。
     *
     * @return Converter<String, List < DegradeRuleEntity>>
     */
    @Bean
    public Converter<String, List<DegradeRuleEntity>> degradeRuleEntityDecoder() {
        return s -> JSON.parseArray(s, DegradeRuleEntity.class);
    }

    /**
     * 配置授权规则Encoder。
     *
     * @return Converter<List < AuthorityRuleEntity>, String>
     */
    @Bean
    public Converter<List<AuthorityRuleEntity>, String> authorityRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    /**
     * 配置授权规则Decoder。
     *
     * @return Converter<String, List < AuthorityRuleEntity>>
     */
    @Bean
    public Converter<String, List<AuthorityRuleEntity>> authorityRuleEntityDecoder() {
        return s -> JSON.parseArray(s, AuthorityRuleEntity.class);
    }

    /**
     * 配置热点参数规则Encoder。
     *
     * @return Converter<List < ParamFlowRuleEntity>, String>
     */
    @Bean
    public Converter<List<ParamFlowRuleEntity>, String> paramRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    /**
     * 配置热点参数规则Decoder。
     *
     * @return Converter<String, List < ParamFlowRuleEntity>>
     */
    @Bean
    public Converter<String, List<ParamFlowRuleEntity>> paramRuleEntityDecoder() {
        return s -> JSON.parseArray(s, ParamFlowRuleEntity.class);
    }

    /**
     * 配置系统规则Encoder。
     *
     * @return Converter<List < SystemRuleEntity>, String>
     */
    @Bean
    public Converter<List<SystemRuleEntity>, String> systemRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    /**
     * 配置系统规则Decoder。
     *
     * @return Converter<String, List < SystemRuleEntity>>
     */
    @Bean
    public Converter<String, List<SystemRuleEntity>> systemRuleEntityDecoder() {
        return s -> JSON.parseArray(s, SystemRuleEntity.class);
    }

    /**
     * 配置网关API Encoder。
     *
     * @return Converter<List < ApiDefinitionEntity>, String>
     */
    @Bean
    public Converter<List<ApiDefinitionEntity>, String> apiDefinitionEntityEncoder() {
        return JSON::toJSONString;
    }

    /**
     * 配置网关API Decoder。
     *
     * @return Converter<String, List < ApiDefinitionEntity>>
     */
    @Bean
    public Converter<String, List<ApiDefinitionEntity>> apiDefinitionEntityDecoder() {
        return s -> JSON.parseArray(s, ApiDefinitionEntity.class);
    }

    /**
     * 配置网关FlowRule Encoder。
     *
     * @return Converter<List < ApiDefinitionEntity>, String>
     */
    @Bean
    public Converter<List<GatewayFlowRuleEntity>, String> gatewayFlowRuleEntityEncoder() {
        return JSON::toJSONString;
    }

    /**
     * 配置网关FlowRule Decoder。
     *
     * @return Converter<String, List < GatewayFlowRuleEntity>>
     */
    @Bean
    public Converter<String, List<GatewayFlowRuleEntity>> gatewayFlowRuleEntityDecoder() {
        return s -> JSON.parseArray(s, GatewayFlowRuleEntity.class);
    }

    @Bean
    public ConfigService nacosConfigService() throws Exception {
        return ConfigFactory.createConfigService("localhost:8848");
    }
}
