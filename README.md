# Student-Registration-Application
Student Registration JavaFX application shows the Student client registration in the Server side

A program can send and receive objects from another program. You can also send and receive objects using `ObjectOutputStream` and `ObjectInputStream` on socket streams. To enable passing, the objects must be serializable. The following application demonstrates how to send and receive objects. 

The example consists of three classes: 

`StudentAddress.java`

`StudentClient.java`

`StudentServer.java`

The client program collects student information from the client and sends it to a server, as shown in Figure.
The StudentAddress class contains the student information: name, street, city, state, and zip. The StudentAddress class implements the Serializable interface. Therefore, a StudentAddress object can be sent and received using the object output and input streams. 

The client sends a StudentAddress object through an ObjectOutputStream on the output stream socket, and the server receives the Student object through the ObjectInputStream on the input stream socket, as shown in Figure. The client uses the writeObject method in the ObjectOutputStream class to send data about a student to the server, and the server receives the student’s information using the readObject method in the ObjectInputStream class. The server and client programs are given in the demo. 

![image](https://user-images.githubusercontent.com/24220136/234778785-a496036c-0885-4244-9cb3-7cbfb644052e.png)

On the client side, when the user clicks the Register to the Server button, the client creates a socket to connect to the host (line 67), creates an ObjectOutputStream on the output stream of the socket (lines 70 and 71), and invokes the writeObject method to send the StudentAddress object to the server through the object output stream (line 83). On the server side, when a client connects to the server, the server creates an 
ObjectInputStream on the input stream of the socket (lines 27 and 28), invokes the readObject method to receive the StudentAddress object through the object input stream (line 31), and writes the object to a file. Demo source code is given in the `StudentRegistration` folder. To run the demo first open the `StudentClient.java` class and run it, when the UI comes out, then run the `StudentServer.java` class to start the Server. 

When the Server started, terminal prompts the following: `Server started`, then it shows the `Student registration` history:

![image](https://user-images.githubusercontent.com/24220136/234779287-0af56c36-4c12-4f57-a5c5-c6a13bf9693a.png)

Following is the Student Client UI and also used to register new student:

![image](https://user-images.githubusercontent.com/24220136/234779355-fa878943-5097-483c-9f66-fe0512d54fbc.png)

And student registration list is recorded in `student.dat` file


