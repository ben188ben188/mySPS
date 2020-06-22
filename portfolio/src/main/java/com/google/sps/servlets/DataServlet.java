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
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.sps.data.CommentHistory;
import java.util.ArrayList;
import java.util.List;


import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

    //private List<CommentHistory> history = new ArrayList<>();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Query query = new Query("CommentHistory").addSort("timestamp", SortDirection.DESCENDING);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PreparedQuery results = datastore.prepare(query);

    List<CommentHistory> list = new ArrayList<CommentHistory>();
    for (Entity entity : results.asIterable()) {
      long id = entity.getKey().getId();
      String email = (String) entity.getProperty("email");
      String name = (String) entity.getProperty("name");
      String comment = (String) entity.getProperty("comment");
      long timestamp = (long) entity.getProperty("timestamp");

      CommentHistory c = new CommentHistory(id,email,name,comment,timestamp);
      list.add(c);
    }

  
  
    response.setContentType("application/json");
    String json = new Gson().toJson(list);
    response.getWriter().println(json);
    
    
    

    
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
@Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the input from the form.
    // CommentHistory com=new CommentHistory();
    String emailInput = getParameter(request, "email-input", "");
    String text = getParameter(request, "name-input", "");
   
    String text1 = getParameter(request, "comment-input", "");
    //set 
    // com.setName(text);
    // com.setComment(text1);
    // history.add(com);
    long timestamp = System.currentTimeMillis();
   // response.sendRedirect("/index.html");
    Entity commentEntity = new Entity("CommentHistory");
    commentEntity.setProperty("email",emailInput);
    commentEntity.setProperty("name",text);
    commentEntity.setProperty("comment", text1);
    commentEntity.setProperty("timestamp", timestamp);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(commentEntity);
    response.sendRedirect("/index.html");
  }

  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }

}

