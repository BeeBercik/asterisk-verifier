# Asterisk Verifier
Project implemented in Java using Maven. Program checks AWS IAM Role Policy document in .json format.  
If document is incorrect or there is different problem with file it throws exceptions.  
Program also follows other criteria. There are 2 various values that can be returned:
- false - if "Resource" field contains single asterisk
- true - if "Resource" field contains any different value  

Project includes eight tests which check correctness of the result.

## How to run
- Make sure you have the latest JDK version
- You should also have IntelliJ on your computer

### In IntelliJ Editor
1. Open Intellij
2. Click "Get from VCS"
3. Copy this link to repo: `https://github.com/BeeBercik/asterisk-verifier.git` and paste it into the URL section
4. Click "clone" button

### Using commands
1. Open command line
2. Get to IdeaProjects (path to your IdeaProjects directory)
3. Enter `git clone https://github.com/BeeBercik/asterisk-verifier.git`
4. Open IntelliJ and choose "open" (or File -> open if you have already opened project)
5. Choose `asterisk-verifier` directory
