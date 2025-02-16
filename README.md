# JavaServlet
## college code on java servlet
### to access code 
1. click on main.
2. select which practical you want.
3. either you can clone it or copy paste code.
4. you can find code in src > java/package folder > and for web file > web folder 
5. or else open NETBEANS > click on TEAMS > GIT > CLONE > add REPOSITORY URL > select which BRANCH (i.e Practical) you want to CLONE  > clone name set to project name u want > FINISH.
6. ### note : change author name as well project name and database name inside code if you are following step 5
### LIST OF PRACTICAL.
1a Create a single application which greets user using servlet.

1b To create a simple calculator application using servlet.

1c Create a servlet for login page if the username and password are correct then it says message hello username else login failed.(without jdbc)

### for jdbc code first create database Steps:
1. SERVICES > DATABASES > JAVA DB > RIGHT CLICK > CREATE DATABASE > WRITE USERNAME AND PASSWORD ( DATABASE NAME -ROLLNO, USERNAME PASSWORD- root,root > FINISH.
2. RIGHT CLICK AGAIN START DATABASE > EXECUTE COMMAND TO CHECK IF IT IS WORKING PROPERLY.

2a Create a registration servlet in JDBC accept the details such as username, password, email, country from user using html and store data in database.

2b Using request dispatcher interface create a servlet which will validate the password enter by the user using jdbc from the data base for correct credentials forward to welcome servlet else the user will stay on index.html and an error message will be displayed.

3a Create a servlet that uses cookies to store the number of time a user has visited the servlet.(practical 3 CookieVistedServlet)

3b Create a servlet demonstrating the use of session creation and destruction also check the number of visits and the other details of session.(practical 3 SessionVistedServlet)

4a Develop simple servlet question answer application using database.
## for practical 4 
--> u need to create table u can add manually through directly executing command in java db database.

CREATE TABLE Quiz(
    Qno INT PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    option1 VARCHAR(100) NOT NULL,
    option2 VARCHAR(100) NOT NULL,
    option3 VARCHAR(100) NOT NULL,
    option4 VARCHAR(100) NOT NULL,
    correct_answer VARCHAR(100) NOT NULL
);

--> also add value -->

INSERT INTO Quiz 
(Qno, question, option1, option2, option3, option4, correct_answer)
VALUES
(1, 'What is the National Animal of India?', 'Lion', 'Tiger', 'Elephant', 'Leopard', 'Tiger'),
(2, 'What is the National Bird of India?', 'Peacock', 'Sparrow', 'Eagle', 'Pigeon', 'Peacock'),
(3, 'What is the National Fruit of India?', 'Mango', 'Banana', 'Papaya', 'Apple', 'Mango'),
(4, 'What is the National Flower of India?', 'Lily', 'Rose', 'Lotus', 'Sunflower', 'Lotus'),
(5, 'What is the National Currency of India?', 'Rupee', 'Dollar', 'Yen', 'Pound', 'Rupee'),
(6, 'What is the National Tree of India?', 'Banyan', 'Neem', 'Peepal', 'Mango', 'Banyan'),
(7, 'Who is known as the Father of the Nation in India?', 'Jawaharlal Nehru', 'Subhas Chandra Bose', 'Mahatma Gandhi', 'Sardar Patel', 'Mahatma Gandhi'),
(8, 'What is the National Anthem of India?', 'Jana Gana Mana', 'Vande Mataram', 'Saare Jahaan Se Achha', 'Bharat Humko Jaan Se Pyara Hai', 'Jana Gana Mana'),
(9, 'What is the Capital of India?', 'Mumbai', 'New Delhi', 'Kolkata', 'Chennai', 'New Delhi'),
(10, 'What is the National Game of India?', 'Football', 'Tennis', 'Cricket', 'Hockey', 'Hockey');

##### steps:- services >  databases > java DB > right click on your database link and connect & execute command and paste above sql query.

------------------------------------------------------------------------------------------------------------------------------------

5a Write a servlet program to Upload a file.

5b Write a servlet program to Download a file.

5c Non blocking io.

------------------------------------------------------------------------------------------------------------------------
#### for practical 6c we need table which is already created in practical 2 registration servlet. so use it 

6a Simple JSP application to display values obtained from the use of intrinsic objects

6b Develop a simple JSP application to pass values from one page to another with validations (name-textbox ,age-textbox, hobbies checkbox, gender- radiobutton, email- textbox)

6c Create a registration and login JSP application to register and authenticate the user based on the username and password using JDBC.

------------------------------------------------------------------------------------------------------------


7a Create an html page with fills employee no. , Name, age, designation, salary and a submit button on the click of submit button the data goes to a JSP page which will update the employee table of the database with matching employee no.

7b Create a JSP page to demonstrate the use of expression language.

7c Create a jsp application to demonstrate the use of JSTL. 

-------------------------------------------------------------------------------------------------------------

8a Create a currency converter application using EJB.

8b Develop a simple room reservation system application using EJB.

9a Develop a simple EJB application to demonstrate servlet hit count using single ton session beans.

9b Develop a JPA Application to demonstrate use of ORM associations.  

10a Develop a guest book application using JPA.

10b Develop a hibernate application to store the feedback of website visitor in database.
