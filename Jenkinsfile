pipeline {
   agent any 
   stages {
      stage("Compile"){
      	sh "./gradlew compileJava"
      }
      stage("Unit test"){
      	sh "./gradlew test"
      }
   }
}
