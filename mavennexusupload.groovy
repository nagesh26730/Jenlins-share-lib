def call(conf){
def repoName = conf["repoName"]
def pomFile = readMavenPom file: 'pom.xml'
def version = pomFile.version
def artifactId = pomFile.artifactId
def groupId = pomFile.groupId
def type = pomFile.packaging
  
  nexusArtifactUploader artifacts: [[artifactId: "$ {artifactId}", classifier: '', file: "target/${artifactId}-${version}.war", type: type]], credentialsId: 'nexus3', groupId: groupId, nexusUrl: '15.207.100.32:8081/', nexusVersion: 'nexus3', protocol: 'http', repository: repoName, version: "${version}"
            
}
