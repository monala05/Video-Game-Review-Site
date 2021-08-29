# Video-Game-Review-Site
Seattle Per Scholas case study 

Summary
A video game review web application, where a user can make an account then write reviews based on video games in the web apps database. The stack used in this project is, Java and MariaDB, with the Springboot framework, Jsp was used to display the page using the Bootstrap framework.

User Stories
•	As a website user I want to be able to log in so I can access my reviews
•	As a website user I want to be able to create a profile so I can log in
•	As a user I want to create a review so that I can share my thoughts
•	As a user I want to be able to see my reviews so I can see what I've written
•	As a user I want to be able to discuss my favorite topic so I can see what others think
•	As a user I want to be able to logout, so I know my session is safe
•	As a user I want to be able to update my profile 
•	As an admin I want to be able to add games so others can review them
•	As a user I want to be able to search for games to see the reviews
•	As an admin I want to be able to delete games. 
•	As a user I want to see fun game information on the cover so I can learn about games

Technical challenges
I faced many different challenges during the creation of this project, as I have never used Spring. Learning how to implement the persistence layer along with the MVC principal was quite a challenge. The first challenge I faced was learning how a controller handles displaying your web pages. I kept getting many 404s before I learned the proper configuration to start my project. Having my project up and running, the next challenge was how to properly get foreign key relations configured using spring. With some helpful tips from the internet, I was able to successfully configure foreign key constraints. Having my controller communicate with my JSP side was pretty tough at first, especially since I was getting used to IOC so it was tough to understand where the data was coming from or where it was going. I was also unfamiliar with JSTL, and Thymeleaf, and I barely knew any JSP expressions. So getting my data to display once I was able to retrieve it was pretty tough. The next big challenge was implementing Spring security. I had to get help on this problem but learned plenty about the config and the general flow of setting up. The next big technical challenge I had was learning about requests and how URI's work and how we can send them and manipulate them to get the info we need. A challenge I couldn't overcome with this time limit was learning how to set up a call to an external API. I wanted to get data from an external source to make my web app current with real video game information. But after a day of fighting to even understand how the URL retrieves the JSON file, and how to begin even reading that JSON file, I realized It would take far too long for me to even start using the API, and decided to leave for another personal project in the future. Time was a huge challenge during this project, I thought my project was simple but, I overestimated the amount of time it would take for me to complete each task, and the result was not was I envisioned as a consequence. Overall it was a great learning experience, and I look forward to getting more real hands-on experience like this project. 
