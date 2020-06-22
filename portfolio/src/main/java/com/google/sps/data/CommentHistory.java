package com.google.sps.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the subtraction game, where players take turns subtracting from 21 to reach 0.
 *
 * <p>Note: The private variables in this class are converted into JSON.
 */
public class CommentHistory {
    private long id;

  /** List of descriptions of turns, e.g. "Player 1 took 3. New total: 18" */
  private String email;
  private String name;
  private String comment;
  private long timestamp;
  
  public CommentHistory()
  {

  }

   public CommentHistory(long id, String email, String name, String comment, long timestamp)
  {
   this.id=id;
   this.email=email;
   this.name=name;
   this.comment=comment;
   this.timestamp=timestamp;
  }

   public void  setName(String na)
   {
       name=na;
   }

   public void  setEmail(String em)
   {
       email=em;
   }

   public void  setComment(String co)
   {
       comment=co;
   }

   public String getName()
   {
       return name;
   }

   public String getEmail()
   {
       return email;
   }

   public String getComment()
   {
       return comment;
   }

   public void setId(long id){
       this.id=id;
   }

   public long getId(){
       return id;
   }

     public void setTimestamp(long timestamp){
       this.timestamp=timestamp;
   }

   public long getTimestamp(){
       return timestamp;
   }


   
  

  

}