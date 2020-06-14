// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    response.getWriter().println("<h1>Hell world! Bin Yang</h1>");
    
    String json = convertToJson();

    response.setContentType("application/json;");
    response.getWriter().println(json);
    
    PresonIn person1=new PresonIn();
    person1.setName("Bin");
    person1.setAge(28);
    person1.setAddress("flushing");
    String person11=convertToJsonUsingGson(person1);
    response.setContentType("application/json;");
    response.getWriter().println(person11);

    
}
private String convertToJson() {
    String json = "{";
    json += "\"acc\"";
    json += ", ";
    json += "\"acc\"";
    json += "}";
    return json;  
}

private String convertToJsonUsingGson(PresonIn p1) {
    Gson gson = new Gson();
    String json = gson.toJson(p1);
    return json;
  }

}