# Conversa - A Chatroom API

# Table of Contents
1. [Project Description](#project-description)
2. [Installation instructions](#installation-instructions)
3. [Usage](#usage)
4. [Contributing Instructions](#contributing-instructions)
5. [Licences](#licences)
6. [References](#references)


## Project Description

This back-end project utilised Java, Spring Boot and a PostgreSQL database to build a chatroom API that would allow the user to make requests using Postman.


The motivation behind this project is to develop an understanding of creating a back-end API utilising Spring Framework and a PostgreSQL database.


**The names and versions of any libraries used**
Spring Boot: Ver. 3.2.3
Spring Boot Dev Tools
Spring Web
PostgreSQL Driver
Spring Data JPA




### MVP
- Create a database called chatroom_db.
- Create Models and DTOs for User, Chatroom, and Message.
- Create a DataLoader which populates our table with sample data to use for testing purposes.
- Create Repositories for User, Chatroom, and Message.
- Create Controllers and Services to cover the Create, Read, Update and Delete (CRUD) routes for User, Chatroom, and Message.

### Extensions
- Create derived queries to enable functionality to filter by chatroom_id and filter by user_id.
- Add functionality for a user to add a profile picture.
- Add functionality for a user to post images to a chatroom.
- Add an AI chatbot to a chatroom and add functionality to enable it to respond to messages from a user.
- Import external AI APIs to allow for an increased scope of responses for the Ai chatbot.
- Create public/private chatrooms using Booleans.
- Add functionality for a user to post voicenotes in a chatroom.


### Entity relationship diagrams
![Screenshot 2024-03-05 at 12 40 25](https://github.com/sahilpatel1906/Conversa_API/assets/156658708/5edc7e0a-f2b7-4ad4-b7c7-7fe3eae8032c)



### Class diagrams
<img width="953" alt="Screenshot 2024-03-05 at 12 48 26" src="https://github.com/sahilpatel1906/Conversa_API/assets/156658708/9c30b07a-2576-43a8-a84d-7c23a0604c11">


### The URL of the GitHub repository that contains the code:

https://github.com/sahilpatel1906/Conversa_API/


## Installation instructions
- Install Postman, Postico, PostgreSQL and your preferred IDE.
- In terminal or Gitbash, navigate to the directory you want to copy the repository into. \
Run the command ```git clone git@github.com:sahilpatel1906/Conversa_API.git```
- Run the command **git pull** to ensure you have the latest version.
- Open the project in the preferred IDE such as IntelliJ.
- In the terminal or Gitbash, create the database called chatroom_db by running the command ```createdb chatroom_db```.
- Run the ConversaApiApplication file.


## Usage



**List of routes for the Conversa API**                    
- Users:
  - GET:                 
    - getAllUsers: “localhost:8080/users/admin”
    - Sample Output:
      ```javascript
      [
        {
            "id": 2,
            "username": "Marvellous",
            "email": "marvellous@outlook.com",
            "messages": [
                {
                    "id": 4,
                    "message": "Shush! I can’t hear what the voices are saying.",
                    "user": {
                        "id": 2,
                        "username": "Marvellous",
                        "email": "marvellous@outlook.com"
                    },
                    "chatroom": {
                        "id": 1,
                        "name": "Axolotl"
                    }
                }
            ]
        },
        {
            "id": 3,
            "username": "Jean",
            "email": "jean@hotmail.com",
            "messages": [
                {
                    "id": 3,
                    "message": "If, at first, you don’t succeed, destroy the evidence that you tried.",
                    "user": {
                        "id": 3,
                        "username": "Jean",
                        "email": "jean@hotmail.com"
                    },
                    "chatroom": {
                        "id": 2,
                        "name": "Gecko"
                    }
                }
            ]
        }
      ]
      
    - getUserById: “localhost:8080/users/{id}”
      

  - POST:
    - addNewUser: “localhost:8080/users” -> Request Body:
      - Sample payload:
        ```javascript
        {
          "username": "Gorilla",
          "email": "Gorilla@Gorilla.com"
        }
      
Messages: 
- GET:
  - getAllMessages: “localhost:8080/messages/admin”
  - getMessagesById: “localhost:8080/messages/{id}

POST
  - addNewMessage: “localhost:8080/messages” -> Request Body:
    - Sample payload: 
        ```javascript
      {
          "userId" : 2,
          "message" : "Earth is this galaxy's insane asylum. Welcome to my ward.",
          "chatroomId" : 3
      }
    
DELETE
  - deleteMessage: “localhost:8080/messages/{id}”

Chatrooms: 
- GET:
  - getAllChatrooms: “localhost:8080/chatrooms/admin”
  - getChatroomsById:  “localhost:8080/chatrooms/{id}”

POST:
  - addNewchatroom: “localhost:8080/chatrooms/” -> Request Body:
    - Sample payload:
    ```javascript
    {
       "name": "Gorilla"
    }

DELETE:
  - deleteChatroomsById: “localhost:8080/chatrooms/{id}” 






### Image displaying the chatroom_db database tables in Postico



<img width="487" alt="Screenshot 2024-03-05 at 14 22 42" src="https://github.com/sahilpatel1906/Conversa_API/assets/156658708/35f58eb8-4b63-43c9-9adb-de81763b139a">

**The first image displays the database table overview** 



<img width="473" alt="Screenshot 2024-03-05 at 14 23 02" src="https://github.com/sahilpatel1906/Conversa_API/assets/156658708/8b4f5713-7cf6-4751-a436-3f3eb16b6c80">

**This image displays the chatrooms table**



<img width="725" alt="Screenshot 2024-03-05 at 14 23 14" src="https://github.com/sahilpatel1906/Conversa_API/assets/156658708/adbae0c3-86e7-4574-ba6a-919258563b98">

**This image displays the messages table**



<img width="447" alt="Screenshot 2024-03-05 at 14 23 25" src="https://github.com/sahilpatel1906/Conversa_API/assets/156658708/0798532c-139d-4dc9-a92c-01480b2a3fe5">

**This image displays the users table**


## Contributing Instructions

We appreciate your interest in contributing to the Conversa API Project. We welcome contributions of all kinds, from bug reports and documentation improvements to new features and code changes.

Find below our contributing guidelines. By following these guidelines, you'll help us to maintain a high quality codebase and make the review process smoother for everyone.

**1. Fork the Repository:** Create a fork of the Conversa_API repository on GitHub.

**2. Create a Branch:** Clone the forked repository to your local machine & create a new branch for your contribution.

**3.Make Changes:** Make your changes to the code & ensure your changes follow our coding style.

**4. Commit Your Changes:** Commit your changes to your local branch with a descriptive commit message.

**5. Push Your Changes:** Push your changes to your forked repository on GitHub.
     
**6. Create a Pull Request:** Open a pull request from your branch to the main branch of the upstream repository.

**7. Review and Feedback:** We will review your pull request and provide feedback.



















### Collaborators:
- Sahil Patel - GitHub: https://github.com/sahilpatel1906
- Marvellous Akib - Github: https://github.com/Marv3llous
- Yesica Nithiyanantha- Github: https://github.com/ney601
- Aebel Shajan - Github: https://github.com/Aebel-Shajan
- Jean Marwizi - Github: https://github.com/Jean-005



## Licences

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)




## References 













