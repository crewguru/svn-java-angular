package com.crewguru.component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;


@Component
public class S3Service {
	
	public AmazonS3 getAmazonS3()
	{
		AWSCredentials credentials=new BasicAWSCredentials(CrewguruS3Resources.S3_KEY,CrewguruS3Resources.S3_SECRET );
		
		
		
		//credentials= new BasicAWSCredentials("AKIAIZW6AZKYMP2YFJ6Q","yi5MMp/0fUuOKPwGDkXShS8IfhHo2AgeNwVmWPz0");
		
		AmazonS3 s3client = new AmazonS3Client(credentials);
		
		
		
		
		/*//String bucketName = "crewguru.app.data";
		//s3client.createBucket(bucketName);
		
		//createFolder("crewguru.app.data","profileimages",s3client);
		
		s3client.listBuckets().stream().forEach( bucket-> System.out.println(" - " + bucket.getName()));
		
		//s3client.deleteBucket("crewguru.app.data");
		//s3client.deleteBucket("venkata-test-bucket");
		
		//s3client.listBuckets().stream().forEach( bucket-> System.out.println(" - " + bucket.getName()));
		
		 ObjectListing objects = s3client.listObjects(bucketName);
	        System.out.println("No. of Objects = " + 
	                                           objects.getObjectSummaries().size());
	        File filetoUpload=new File("/Users/venkatakommuri/development/workspace/Crewguruapp/avatar_man.png");
	        String key="profiles/avatar_man.png";
		s3client.putObject(new PutObjectRequest(bucketName, key,filetoUpload));*/
		
		return s3client;
	}
	
	public String uploadFile(String fileName, InputStream is, String bucketName) throws Exception
	{
		AmazonS3 s3client=getAmazonS3();
		ObjectMetadata metadata=new ObjectMetadata();	
		//metadata.setContentLength(0);
		//metadata.set
		PutObjectResult result=s3client.putObject(new PutObjectRequest(bucketName, fileName,is,metadata).withCannedAcl(CannedAccessControlList.PublicRead));
		String path="https://s3-"+Region.getRegion(Regions.US_WEST_2).getName()+".amazonaws.com/"+bucketName+"/"+fileName;

		return path;
	}
	
	public void createFolder(String bucketName, String folderName,  AmazonS3 amazons3){
		
		ObjectMetadata metadata=new ObjectMetadata();
		//metadata.
		
		metadata.setContentLength(0);
		
		InputStream emptyContent= new ByteArrayInputStream(new byte[0]);
		
		PutObjectRequest putobject=new PutObjectRequest(bucketName, folderName+"/", emptyContent, metadata);
		
		
		
	}
	
	public static void main(String args[])
	{
		S3Service s3=new S3Service();
		AmazonS3Client s3client=(AmazonS3Client) s3.getAmazonS3();
		//URL url=s3client.getUrl("www.crewguru.com", "profiles/tej.jpg");
		String bucketName="www.crewguru.com";
		String fileName="profiles/tej.jpg";
		//S3Object s3obj=s3client.getObject(null);
		String path="https://s3-"+Region.getRegion(Regions.US_WEST_2).getName()+".amazonaws.com/"+bucketName+"/"+fileName;
		System.out.println("Path is "+path);
		//String host=url.getHost();
		String url=s3client.getResourceUrl(bucketName,fileName);
		System.out.println("Path is "+url);
		//String regname=region.name();
		//s3.uploadFile(fileName, is, s3client, bucketName);
	}

}
