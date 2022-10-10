pipeline {
   agent any 
   stages {
      stage("Compile"){
      	steps {
        	sh "./gradlew compileJava"
        }
      }
      stage("Unit test"){
      	 steps {
      	 	sh "./gradlew test"
      	 }
      }
      stage("Code coverage"){
      	steps {
      		sh "./gradlew jacocoTestReport"
            publishHTML (target: [
               reportDir: 'build/reports/jacoco/test/html',
               reportFiles: 'index.html',
               reportName: "JaCoCo Report"
             ])
      		sh "./gradlew jacocoTestCoverageVerification"
      	}
      }
      stage("Static code analysis"){
      	steps{
      		sh "./gradlew checkstyleMain"
      		publishHTML (target: [
      		    reportDir: 'build/reports/checkstyle/',
      		    reportFiles: 'main.html',
      		    reportName: "Checkstyle Report"
      	   ])
      	}
      }
      stage("Package"){
      	steps{
      		sh "./gradlew build"
      	}
      }
      stage("Docker build"){
      	steps{
      		sh "docker build -t cartman81/calculator:${BUILD_TIMESTAMP} ."
      	}
      }
      
      /*stage("Docker login") {
		     steps {
		          withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub-credentials',
		                   usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
		               sh "docker login --username $USERNAME --password $PASSWORD"
		          }
		     }
       }

		stage("Docker push") {
		     steps {
		          sh "docker push cartman81/calculator"
		     }
		}*/

      stage("Docker push"){
      	steps{
      		script {
	      		withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
				   sh 'docker login -u cartman81 -p ${dockerhubpwd}'
	               sh "docker push cartman81/calculator:${BUILD_TIMESTAMP}"
				}
      		}
      	}
      }
      stage("Update version") {
               steps {
                    sh "sed  -i 's/{{VERSION}}/${BUILD_TIMESTAMP}/g' deployment.yml"
               }
      }
      stage("Deploy to staging"){
      	steps{
      		/*sh "docker run -d --rm -p 8765:8080 --name calculator cartman81/calculator"*/
      		sh "kubectl config use-context staging"
            sh "kubectl apply -f hazelcast.yml"
            sh "kubectl apply -f deployment.yml"
            sh "kubectl apply -f service.yml"
      	}
      }
      stage("Acceptance test"){
      	steps{
      	    sleep 60
      		sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
      	}
      }
      stage("Release") {
         steps {
            sh "kubectl config use-context production"
            sh "kubectl apply -f hazelcast.yaml"
            sh "kubectl apply -f deployment.yaml"
            sh "kubectl apply -f service.yaml"                    
          }
       }
       stage("Smoke test") {
          steps {
             sleep 60
             sh "chmod +x smoke-test.sh && ./smoke-test.sh"
          }
        }
   }
   /*post{
   	always{
   		sh "docker stop calculator"
   	}
   }*/
}
