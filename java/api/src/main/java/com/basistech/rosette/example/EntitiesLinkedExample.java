/******************************************************************************
 ** Copyright (c) 2014-2015 Basis Technology Corporation.
 **
 ** Licensed under the Apache License, Version 2.0 (the "License");
 ** you may not use this file except in compliance with the License.
 ** You may obtain a copy of the License at
 **
 **     http://www.apache.org/licenses/LICENSE-2.0
 **
 ** Unless required by applicable law or agreed to in writing, software
 ** distributed under the License is distributed on an "AS IS" BASIS,
 ** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ** See the License for the specific language governing permissions and
 ** limitations under the License.
 ******************************************************************************/

package com.basistech.rosette.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import com.basistech.rosette.api.RosetteAPIException;
import com.basistech.rosette.apimodel.LinkedEntity;
import com.basistech.rosette.apimodel.LinkedEntityResponse;

/**
 * Example which demonstrates the linked entities endpoint
 */
public final class EntitiesLinkedExample extends AbstractExample {

    public EntitiesLinkedExample() {
        try {
            url = new URL("http://www.basistech.com/about/");
        } catch (MalformedURLException e) {
            System.err.println(e.toString());
        }
    }
    
    /**
     * Main program.
     * Creates a RosetteAPI instance with the API key defined in rosette.api.key property.
     * Gets linked entities as a demonstration of usage.
     *
     * @param args
     * @throws java.net.URISyntaxException
     * @throws java.io.IOException
     */
    public void main(String[] args) throws URISyntaxException, IOException {
        new EntitiesLinkedExample().run(args);
    }

    @Override
    protected void run(String[] args) {
        super.run(args);
        doLinkedEntity(text);
    }
    
    /**
     * Sends linked entity request from text.
     * @param text
     */
    private void doLinkedEntity(String text) {
        try {
            LinkedEntityResponse entityResponse = rosetteAPI.getLinkedEntity(text, null, null);
            print(entityResponse);
        } catch (RosetteAPIException e) {
            System.err.println(e.toString());
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

        /**
         * Prints linked entity response.
         * @param entityResponse
         */
    private static void print(LinkedEntityResponse entityResponse) {
        System.out.println(entityResponse.getRequestId());
        for (LinkedEntity entity : entityResponse.getEntities()) {
            System.out.printf("%s\t%d\t%s\t%f\n",
                    entity.getEntityId(),
                    entity.getIndocChainId(),
                    entity.getMention(),
                    entity.getConfidence());
        }
        System.out.println();
    }
}
