# Student-Registration-Application
Student Registration JavaFX application shows the Student client registration in the Server side

- A program can send and receive objects from another program. You can also send and receive objects using `ObjectOutputStream` and `ObjectInputStream` on socket streams. To enable passing, the objects must be serializable. The following application demonstrates how to send and receive objects. 

- The example consists of three classes: 

`StudentAddress.java`

`StudentClient.java`

`StudentServer.java`

- The client program collects student information from the client and sends it to a server, as shown in Figure.
The StudentAddress class contains the student information: name, street, city, state, and zip. The StudentAddress class implements the Serializable interface. Therefore, a StudentAddress object can be sent and received using the object output and input streams. 

- The client sends a StudentAddress object through an ObjectOutputStream on the output stream socket, and the server receives the Student object through the ObjectInputStream on the input stream socket, as shown in Figure. The client uses the writeObject method in the ObjectOutputStream class to send data about a student to the server, and the server receives the student’s information using the readObject method in the ObjectInputStream class. The server and client programs are given in the demo. 

![image](https://user-images.githubusercontent.com/24220136/234778785-a496036c-0885-4244-9cb3-7cbfb644052e.png)

- On the client side, when the user clicks the Register to the Server button, the client creates a socket to connect to the host (line 67), creates an ObjectOutputStream on the output stream of the socket (lines 70 and 71), and invokes the writeObject method to send the StudentAddress object to the server through the object output stream (line 83). On the server side, when a client connects to the server, the server creates an 
ObjectInputStream on the input stream of the socket (lines 27 and 28), invokes the readObject method to receive the StudentAddress object through the object input stream (line 31), and writes the object to a file. Demo source code is given in the `StudentRegistration` folder. To run the demo first open the `StudentClient.java` class and run it, when the UI comes out, then run the `StudentServer.java` class to start the Server. 

- When the Server started, terminal prompts the following: `Server started`, then it shows the `Student registration` history:

![image](https://user-images.githubusercontent.com/24220136/234779287-0af56c36-4c12-4f57-a5c5-c6a13bf9693a.png)

- Following is the Student Client UI and also used to register new student:

![image](https://user-images.githubusercontent.com/24220136/234779355-fa878943-5097-483c-9f66-fe0512d54fbc.png)

- And student registration list is recorded in `student.dat` file

-------------------------

## [Implementation](https://github.com/af4092/Student-Registration-Application/tree/main/StudentRegistration)

- `StudentServer.java` provides a Java class named `StudentServer` that represents a server for student registration. It listens for client connections, receives student objects from clients, and stores them in a file. Here is a general explanation of the code:

  - The code is in a package named `com.special.effect.javafxprojects.StudentRegistration`.

  - The StudentServer class contains a main method that serves as the entry point of the server application.

  - Inside the main method, an instance of the StudentServer class is created, which starts the server.

  - The constructor of the StudentServer class performs the following operations:
 
      - Creates a `ServerSocket` instance on `port:8000` to listen for client connections.
      - Creates an `ObjectOutputStream` named `outputToFile` to write student objects to a file named `student.dat`. The true parameter passed to the `FileOutputStream` constructor enables appending to an existing file.
      - Enters an infinite loop to continuously accept client connections and receive student objects.
      - When a client connects, a Socket named socket is created to handle the connection.
      - An `ObjectInputStream` named `inputFromClient` is created to read student objects from the client.
      - The `readObject` method is called on `inputFromClient` to receive the student object sent by the client.
      - The received student object is written to the file using `outputToFile.writeObject(object)`.
      - A message is printed to the console to indicate that a new student object has been stored.
      - The code includes exception handling using try-catch blocks:

  - If a `ClassNotFoundException` occurs while reading the object from the client, the stack trace is printed. If an `IOException` occurs while accepting connections or reading/writing objects, the stack trace is printed.
  - In the finally block, the `inputFromClient` and outputToFile streams are closed.

- `StudentClient.java` represents the client-side of a client-server application for student registration. Here is a general explanation of the code:

  - The code is in a package named `com.special.effect.javafxprojects.StudentRegistration`.
  - The `StudentClient` class extends the Application class, which is the entry point for JavaFX applications.
  - The class includes instance variables representing text fields (txtName, txtStreet, txtCity, txtState, txtZip), and a button (btnRegister) used in the user interface.
  - The start method is overridden from the Application class and is the main entry point of the JavaFX application.
  - Inside the start method, a `GridPane` named pane is created to organize the UI components.
  - Labels and text fields are added to the pane using the pane.add method, specifying the column and row indices.
  - An `HBox` named hBox is created to hold the city, state, and zip fields horizontally.
  - The hBox and additional labels and text fields are added to the pane using the pane.add method.
  - The `btnRegister` button is added to the pane using the pane.add method. The `GridPane.setHalignment` method is used to align the button to the right.
  - The pane is aligned to the center using `pane.setAlignment(Pos.CENTER)`.
  - The preferred column count for each text field is set using `setPrefColumnCount`.
  - An event handler is registered for the `btnRegister` button using the `btnRegister.setOnAction` method. The event handler is defined as an inner class named `ButtonListener`.
  - Inside the ButtonListener class, the handle method is overridden to define the actions performed when the button is clicked.
  - In the handle method, a Socket named socket is created to establish a connection with the server running on the localhost and `port:8000`.
  - An `ObjectOutputStream` named toServer is created from the `socket.getOutputStream()` to send objects to the server.
  - The text values from the text fields are retrieved and stored in variables.
  - A `StudentAddress` object is created using the retrieved text values.
  - The studentAddress object is written to the server using `toServer.writeObject(studentAddress)`.
  - Exception handling is included, and any exceptions thrown are wrapped in a `RuntimeException`.
  - The JavaFX application window is displayed with the specified dimensions and title.
