/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cassandra.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import org.apache.cassandra.io.util.File;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigTestTransferHintsOnDecommissionTest
{
    public static Config load(String path)
    {
        URL url = YamlConfigurationLoaderTest.class.getClassLoader().getResource(path);
        if (url == null)
        {
            try
            {
                url = new File(path).toPath().toUri().toURL();
            }
            catch (MalformedURLException e)
            {
                throw new AssertionError(e);
            }
        }
        return new YamlConfigurationLoader().loadConfig(url);
    }
    @Test
    public void test()
    {
//        Config c = load("test/conf/cassandra.yaml");
        Config c = load("test/conf/cassandra-transfer_hints_on_decommission.yaml");
        assertThat(c.transfer_hints_on_decommission).isNotNull();
        assertThat(c.transfer_hints_on_decommission).isTrue();
    }
}