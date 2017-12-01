package com.maven.download;

import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.Authentication;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.ArtifactRequest;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.eclipse.aether.util.repository.AuthenticationBuilder;


public class DownloadMavenJar {

	
	/**
	 * ����RepositorySystem
	 * @return RepositorySystem
	 */
	private static RepositorySystem newRepositorySystem()
    {
        DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
        locator.addService( RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class );
        locator.addService( TransporterFactory.class, FileTransporterFactory.class );
        locator.addService( TransporterFactory.class, HttpTransporterFactory.class );
 
        return locator.getService( RepositorySystem.class );
    }
	/**
	 *  create a repository system session
	 * @param system RepositorySystem
	 * @return RepositorySystemSession
	 */
	private static RepositorySystemSession newSession( RepositorySystem system,String target )
    {
        DefaultRepositorySystemSession session = MavenRepositorySystemUtils.newSession();
 
        LocalRepository localRepo = new LocalRepository( /*"target/local-repo" */target);
        session.setLocalRepositoryManager( system.newLocalRepositoryManager( session, localRepo ) );
 
        return session;
    }
	
	/**
	 *  ��ָ��maven��ַ����ָ��jar��
	 * @param artifact maven-jar������Χ��λ��groupId:artifactId:version)
	 * @param repositoryURL maven���URL��ַ
	 * @param username ����ҪȨ�ޣ�����ʹ�ô˲�������û�����������Ϊnull
	 * @param password ͬ��
	 * @throws ArtifactResolutionException
	 */
	public static void DownLoad(Params params) throws ArtifactResolutionException 
	{
				String groupId=params.getGroupId();
				String artifactId=params.getArtifactId();
				String version=params.getVersion();
				String repositoryUrl=params.getRepository();
				String target=params.getTarget();
				String username=params.getUsername();
				String password=params.getPassword();
		
		
		    RepositorySystem repoSystem = newRepositorySystem();
        RepositorySystemSession session = newSession( repoSystem ,target);
        RemoteRepository central=null;
        if(username==null&&password==null)
        {
        	central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).build();
        }else{
        	 Authentication authentication=new AuthenticationBuilder().addUsername(username).addPassword(password).build();
        	 central = new RemoteRepository.Builder( "central", "default", repositoryUrl ).setAuthentication(authentication).build();
        }
        /**
         * ����һ��jar��
         */
        Artifact artifact=new DefaultArtifact(groupId+":"+artifactId+":"+version);
        ArtifactRequest artifactRequest=new ArtifactRequest();
        artifactRequest.addRepository(central);
        artifactRequest.setArtifact(artifact);
        repoSystem.resolveArtifact(session, artifactRequest);
        System.out.println("success");
	}
}
