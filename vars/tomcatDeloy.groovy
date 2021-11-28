
def call(ip,credsID,myName){
  sshagent(["${credsID}"]) {
      sh "scp -o StrictHostKeyChecking=no target/{warName}.war ec2-user@{ip}:/opt/tomcat/webapps/"
      sh "ssh ec2-user@{ip} /opt/tomcat/bin/shutdown.sh"
      sh "ssh ec2-user@{ip} /opt/tomcat/bin/startup.sh
             }
}
