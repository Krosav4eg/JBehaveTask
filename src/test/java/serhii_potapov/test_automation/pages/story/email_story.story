Narrative: Verify that the email system allows log in and log out, create and delete letters.

As an authorized user, I want to login into my email system with provided username and password,
create new email and send it, verify that email is received successfully with the same content
and delete it and logout.

Scenario: Verify that the authorized user can login into email system with provided username and password,
create new email and send it, verify that email is received successfully with the same content
and delete it and logout.
Given I launch http://www.i.ua/ page
When I enter <Email> in the field "Логин" and <Password> in the field "Пароль", then click on button "Войти"
Then I create new letter and send it to <Destination> with <Subject> and <Message>
Then I verify that letter was sent successfully with the proper content
Then I logout from the Email

Examples:
|Email       |Password |Destination |Subject|Message       |
|Zefir74@i.ua|Potapov88|Zefir74@i.ua|Hello  |Hello,Sergey=)|