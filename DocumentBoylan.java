import java.util.*;
public class DocumentBoylan
{
}

/*
Name:           Siobhan Boylan
Date:           September 24, 2023
description:    a Java program that mimics an email app
purpose:        to practice / implement object inheritance
self grade:     100 points
justification:  Naming: I have followed all the naming conventions (5pts)
                Indentation: I have followed all indentation conventions and the code is easy to read (5pts)
                             (I use 4-space indents to be extra clear) 
                Comments: I have commented every part of my code (5pts)
                Program Compiles: My code compiles and contains all required parts (25pts)
                Program Runs: My code runs without error and generates the sample output (30pts)
                Requirements: Program follows all the provided requirements 
                              (methods, signatures, classes implemented properly (25pts)
                Self grade: I have given myself a score of 100 and explained why (5pts) 

Testimony: I have written this program all by myself and have not copied any code from any resourses: Siobhan Boylan 

*/

class Document{

    // instance variable
    private String content;
    
    //Constructor 
    public Document (String text) 
    {
        this.content = text;
    }
    
    // Accessor (get) methods 
    
    //returns the instance variable content 
    public String getText() {
        return this.content;
    }
    
    // Mutator (set) methods  
    
    //changes the instance variable content to the new content
    public void setContent(String newContent) {
        this.content = newContent;
    }
    
    // creates a String representing an object of Document and then returns it
    public String toString() 
    {
        return this.content;
    }
    
    // returns the number of the characters in the document
    public int characterCount() 
    {
        // use .length() to find # characters in String
        return this.content.length();
    }
    
    // returns true if the instance variable content contains the keyword
    public boolean find(String keyword) 
    {
        return this.content.contains(keyword);
    }
    
    // compares two objects of type Document
    // returns true if the two Document objects are the same and returns false otherwise
    public boolean equals(Document other) 
    {
        //returns true if the instance variable content contains the keyword
        return this.content.equalsIgnoreCase(other.content);
    }
 
 
}

class Email extends Document
{
    
    // instance variables
    public String message = "sent emails cannot be modified";                      
    private String sender;
    private String recipient;
    private Date msgDate;
    private String subject;
    private String cc;
    private boolean isSent;
    
    
    // Email Constructor
    public Email(String text, String sender, String recipient, String subject, String cc)     
    {
     
        // call super Constructor
        super(text);
        
        // initialize Email attributes
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.cc = cc;
        this.msgDate = new Date();
    }
    
    // -----------------------
    //   Accessors (getters)
    // -----------------------
    
    // returns the instance variable isSent
    public boolean getIsSent()
    {
       return this.isSent;
    }
    
    
    // returns the instance variable sender
    public String getSender()
    {
       return this.sender;
    }
    
    // returns the instance variables recipient
    public String getRecipient()
    {
       return this.recipient;
    }
    
    // returns the instance variable subject
    public String getSubject()
    {
       return this.subject;
    }
     
     
    // returns the instance variable cc
    public String getCC()
    {
       return this.cc;
    }
     
    // returns the instance variable date
    public Date getDate()
    {
       return this.msgDate;
    }
    
    // // returns the instance variable text (super > content)
//     public String getText()
//     {
//        return super.getText();
//     }
    
    // ----------------------
    //   Mutators (setters)
    // ----------------------
    
    // if email not sent, updates sender
    public void setSender(String sender)
    {
       if (this.isSent == false)
       {
           this.sender = sender;  
       } else
       {
           System.out.println(this.message);
       }
       
    }
    
    // if email not sent, updates recipient
    public void setRecipient(String recipient)
    {
       if (this.isSent == false)
       {
           this.recipient = recipient;  
       } else
       {
           System.out.println(this.message);
       }
    }
    
    // if email not sent, updates subject
    public void setSubject(String subject)
    {
       if (this.isSent == false)
       {
           this.subject = subject;  
       } else
       {
           System.out.println(this.message);
       }
    }
    
    // if email not sent, updates cc
    public void setCC(String cc)
    {
       if (this.isSent == false)
       {
           this.cc = cc;  
       } else
       {
           System.out.println(this.message);
       }
    }
     
    //
    public void editContent(String newText)
    {
       if (this.isSent == false)
       {
           super.setContent(newText);  
       } else
       {
           System.out.println(this.message);
       }
    }
    
    // ------------------
    //   DISPLAY METHOD
    // ------------------
     
    // returns easy-to-read formatted string
    // String must include the 
    // sender, recipient, subject, date 
    // and the content of the email => super.toString();
    public String toString()
    {
       return String.format("To: %s\n" + 
                            "From: %s\n" + 
                            "Subject: %s\n" + 
                            "Date: %s\n" + 
                            "\t%s", 
                            recipient,
                            sender,
                            subject,
                            msgDate,
                            super.toString());
    }
    
    // -----------------
    //   OTHER METHODs
    // -----------------
     
    public void send()
    {
       this.isSent = true;
    }
    
    // creates a new Email object
    // forwards a previously-sent email to new recipient & cc
    public Email forward(String rec, String sender, String cc)
    {
                        // String text, String sender, String recipient, String subject, String cc
       Email f = new Email (this.getText(), sender, rec, "->Forwarded Message-> " + this.subject, cc);
       f.msgDate = new Date();
       f.isSent = true;
       return f;
    }
     
     
} 

//****************************************************************************************

//uncommnet this driver class once you have implemented the Document class and the Email class 
//DO NOT DELETE THIS DRIVER  
    
// class EmailDriver
// {
//     // public Email(String text, String sender,String recipiant, String subject, String cc)
//     public static void main(String[] args)
//     {
//       //creating an Email object
//        Email e1 = new Email("Good morning, the exam date has been changed. check the Canvas", "Teacher","All Students","Exam","");
//       
//        //sending the email
//        e1.send();
//        
//        //disply the details about the email
//        System.out.println(e1);
//        System.out.println("\n\n");
//        
//        //searching the email for the email for the word tomorrow
//        boolean b = e1.find("tmorrow");
//        if(b)
//          System.out.println("The word tomorrow was  found in the email");
//        else
//           System.out.println("The word tomorrow was not found in the email"); 
//            
//       
//        //displaying just the content(text) of the email
//        System.out.println("\nThe content of this email is: " + e1.getText());
//        System.out.println();
//        //modifying the content of the email
//        e1.editContent("bye");
//        
//        //changing the recipient of the e1 email
//        e1.setRecipient("Jose@yahoo.com,Mary@gmail.com");
//        System.out.println();
//        
//        //forwarding the email
//        Email forward = e1.forward("Jose", "Ahmad" ,"Bruce");
//        System.out.println();
//        
//        //printing the forwarded email 
//        System.out.println("Here is the forwarded message\n");
//        System.out.println("forwarded message\n"+ forward);
//        System.out.println();
//        
//        //display the length of the text in the email
//        System.out.println("The number of the letters in the email is: " + e1.characterCount());
//        
//        System.out.println("\n\nDisplaying the email again");
//        
//        System.out.println(e1);
//        
//        //***********************************************************************
//        //your turn, refer to the provided documnet on the codes you need to write
//        
//     }
// }


/*Must implement this class to get 15 points out of 100
*/
class MyDriver
{
    public static void main(String[] args)
    {
        
        //create Email objects
        Email mail1 = new Email("I'll be at your door tomorrow with a giant check.", "Ed McMahon","Jerry Lewis","You've won a million dollars!","");
        Email mail2 = new Email("Supplies!", "Student", "Ms. Janine", "What does a janitor say when he comes out of his closet?", "Quinta");
        
        
        //send the email
        mail1.send();
        
        //disply the email
        System.out.println("Email 1 -->");
        System.out.println(mail1);
        // show character count
        System.out.println("Character count: " + mail1.characterCount() + "\n\n");
        
        System.out.println("Email 2 -->");
        System.out.println(mail2);
        // show character count
        System.out.println("Character count: " + mail2.characterCount() + "\n\n");
        
        //-----------------
        //  check getters
        //-----------------
        System.out.println("email 1 Sender is >> " + mail1.getSender());
        System.out.println("email 1 Recipient is >> " + mail1.getRecipient());
        System.out.println("email 1 Subject is >> " + mail1.getSubject());
        System.out.println("email 1 Content is >> " + mail1.getText());
        
        System.out.println("\n\n");
        
        System.out.println("email 2 Sender is >> " + mail2.getSender());
        System.out.println("email 2 Recipient is >> " + mail2.getRecipient());
        System.out.println("email 2 Subject is >> " + mail2.getSubject());
        System.out.println("email 2 Content is >> " + mail2.getText());
        
        System.out.println("\n\n");
        
        //-----------------
        //  check setters
        //-----------------
        
        System.out.println(">>>>> Checking setters for email 1 >>>>>");
        System.out.print(">>> setSender >>>");
        mail1.setSender("Harvey Milk");
        System.out.print(">>> setRecipient >>>");
        mail1.setRecipient("Leonard Bernstein");
        System.out.print(">>> setSubject >>>");
        mail1.setSubject("Let's collaborate");
        System.out.print(">>> editContent >>>");
        mail1.editContent("We could make something beautiful.");
        
        System.out.println("\n\n");
        
        System.out.println(">>>>> Checking setters for email 2 (not sent) >>>>>");
        System.out.println(">>> setSender >>>");
        mail2.setSender("Quinta");
        System.out.println(">>> setRecipient >>>");
        mail2.setRecipient("Miss Janine");
        System.out.println(">>> setSubject >>>");
        mail2.setSubject("Funniest Joke Ever!");
        System.out.println(">>> editContent >>>");
        mail2.editContent("What does a janitor say when he comes out of his closet?\n\tSupplies!");
        
        System.out.println("\n\n");
        
        //-----------------
        //  check forward
        //-----------------
        
        System.out.println("@@@ Checking forward for email 1 @@@");
        Email checkForward1 = mail1.forward("David Bowie", mail1.getRecipient(), "Papa Smurf");
        System.out.println(checkForward1);
        
        System.out.println("\n\n");
        
        System.out.println("@@@ Checking forward for email 2 @@@");
        Email checkForward2 = mail2.forward("Gregory", mail1.getRecipient(), "Miss Schemmenti");
        System.out.println(checkForward2);
        
        System.out.println("\n\n");
        
        //----------------
        //  check search
        //----------------
        
        String keyword = "closet";
        System.out.println("Searching for " + keyword + " in email 1 " +"...\n");
        
        System.out.print("keyword '" + keyword + "' is");
        if(mail1.find(keyword) == true)
        {
            System.out.print(" found!\n");
        } else
        {
            System.out.print(" NOT found.\n");
        }
        
        System.out.println("\n\n");
        
        System.out.println("Searching for " + keyword + " in email 2 " +"...\n");
        
        System.out.print("keyword '" + keyword + "' is");
        if(mail2.find(keyword) == true)
        {
            System.out.print(" found!\n");
        } else
        {
            System.out.print(" NOT found.\n");
        }
        
        
    }
        
        
}
