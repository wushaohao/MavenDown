package com.maven.download;
/**
 * 这是该demo的入口函数，调用Main.main()函数即可。
 */
import org.eclipse.aether.resolution.ArtifactResolutionException;

public class Main {
	
	public static void main(String[] args) {
		try {
			String url = "http://114.215.178.115:8081/nexus/content/repositories/releases/";
			
			Params params = new Params();
			params.setRepository(url);
			params.setArtifactId("order_center_service_intf");
			params.setGroupId("com.asiainfo.cb2.order");
			params.setVersion("1.0.0");
			params.setTarget("test");

			//下载jar包
			DownloadMavenJar.DownLoad(params);
			
		} catch (ArtifactResolutionException e) {
			System.out.println("下载失败！");
			e.printStackTrace();
		}
	}
}
