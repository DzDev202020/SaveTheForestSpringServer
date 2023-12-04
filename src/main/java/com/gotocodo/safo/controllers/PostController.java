package com.gotocodo.safo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.sql.Date;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import model.Client;
import model.Fire;
import model.Post;
import repository.PostRepository;
import util.MyTime;

@RestController
public class PostController {

	PostRepository postRepository;
	@Value("${file.upload-dir}")
	String pathName;
//	String pathName = "C:\\Users\\Moncef\\Desktop\\last tp\\safo\\src\\main\\resources\\pictures\\";

	public PostController() {
		postRepository = new PostRepository();
	}

//	@RequestMapping(value = "/post", method = RequestMethod.POST)
//	public ResponseEntity<Object> createPost(@RequestBody Post post, @RequestParam("picture") MultipartFile file) {
//
//		if (file != null) {
//			String fileName = post.getId_c() + "_" + post.getId_f() + "_" + MyTime.getTime() + ".jpg";
//
//			File fileLocal = new File(pathName + fileName);
//			try {
//				if (fileLocal.exists())
//					fileLocal.delete();
//
//				fileLocal.createNewFile();
//
//				OutputStream outFile = new FileOutputStream(fileLocal);
//				outFile.flush();
//				outFile.write(file.getBytes());
//				outFile.close();
//
//			} catch (Exception e) {
//				return new ResponseEntity<>("Exeption when create new user", HttpStatus.EXPECTATION_FAILED);
//			}
//
//			post.setPhotoFilePath(fileName);
//		} else {
//			System.out.println("-----------------");
//			System.out.println("-----------------");
//			System.out.println("ON Create Post With No Picture");
//			System.out.println("-----------------");
//			System.out.println("-----------------");
//		}
//
//		post.setCreatedAt(new Date(MyTime.getTime()));
//		Post result = postRepository.create(post);
//
//		if (result != null)
//			return new ResponseEntity<>(post, HttpStatus.CREATED);
//		else
//			return new ResponseEntity<>("Exeption when create new user", HttpStatus.EXPECTATION_FAILED);
//	}

	@RequestMapping(value = "/post/only", method = RequestMethod.POST)
	public ResponseEntity<Post> createPosotOnly(@RequestBody Post post) {

//		Client c= new Client();
//		Fire f =new Fire();
//		c.setId(post.getId_c());
//		f.setId(post.getId_f());
//		
//		post.setrClient(c);
//		post.setrFire(f);
//		
		post.setCreatedAt(new Date(MyTime.getTime()));
		Post result = postRepository.create(post);

		if (result != null)
			return new ResponseEntity<>(post, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value = "/post/{pictureId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPostPicture(@PathVariable("pictureId") String pictureId) {

		String fileName = pictureId;
		File fileLocal = new File(pathName + fileName);

		try {

			if (!fileLocal.exists()) {
				return new ResponseEntity<>("Exeption picture not existe", HttpStatus.EXPECTATION_FAILED);
			}

			InputStream inFile = new FileInputStream(fileLocal);
			byte[] readAllBytes = inFile.readAllBytes();
			inFile.close();

			return new ResponseEntity<>(readAllBytes, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("Exeption when create new user", HttpStatus.EXPECTATION_FAILED);
		}

	}

	@RequestMapping(value = "/post/picture", method = RequestMethod.POST)
	public ResponseEntity<String> createPostPicture(@RequestParam("picture") MultipartFile file) {

//		if (file != null) {
//			String fileName = MyTime.getTime() + ".jpg";
//			File fileLocal = new File(pathName + fileName);
//			try {
//				if (fileLocal.exists())
//					fileLocal.delete();
//
//				fileLocal.createNewFile();
//
//				OutputStream outFile = new FileOutputStream(fileLocal);
//				outFile.flush();
//				outFile.write(file.getBytes());
//				outFile.close();
//
//			} catch (Exception e) {
//				return new ResponseEntity<>("Exeption when create new user", HttpStatus.EXPECTATION_FAILED);
//			}
//
//		} else {
//			System.out.println("-----------------");
//			System.out.println("-----------------");
//			System.out.println("ON Create Post With No Picture");
//			System.out.println("-----------------");
//			System.out.println("-----------------");
//		}

		String fileName = MyTime.getTime() + ".jpg";

		File fileLocal = new File(pathName + fileName);
		try {
			if (fileLocal.exists())
				fileLocal.delete();
			
				fileLocal.createNewFile();

			OutputStream outFile = new FileOutputStream(fileLocal);
			outFile.flush();
			outFile.write(file.getBytes());
			outFile.close();

		} catch (Exception e) {
			return new ResponseEntity<>("Exeption when save picture", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>(fileName, HttpStatus.OK);
	}

//	@RequestMapping(value = "/post/{pictureId}", method = RequestMethod.GET)
//	public ResponseEntity<byte[]> getImageAsResponseEntity(@PathVariable("pictureId") String pictureId) {
//
//		System.out.println("getImageAsResponseEntity id picture: " + pictureId);
//		String fileName = pictureId;
//		File fileLocal = new File(pathName + fileName);
//
//		HttpHeaders headers = new HttpHeaders();
//		InputStream in;
//		try {
//			in = new FileInputStream(fileLocal);
//
//			byte[] media = in.readAllBytes();
////			IOUtils.readFully(in, media);
//
//			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
//			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
//
//			return responseEntity;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//		}
//
//	}

	///
//	
//	 String folderPath="C:/Program Files (x86)/Wowza Media Systems/Wowza Streaming Engine 4.8.0/content/Posters/";
//
//
//	    @RequestMapping("/")
//	    public String showFiles(Model model) {
//	        File folder = new File(folderPath);
//	        File[] listOfFiles = folder.listFiles();
//	        model.addAttribute("files", listOfFiles);
//	        return "showFiles";
//	    }
//	    @RequestMapping("/file/{fileName}")
//	    @ResponseBody
//	    public void show(@PathVariable("fileName") String fileName, HttpServletResponse response) {
//
//
//	        if (fileName.indexOf(".jpg")>-1) response.setContentType("application/jpg");
//
//	          response.setHeader("Content-Disposition", "attachment; filename=" +fileName);
//	          response.setHeader("Content-Transfer-Encoding", "binary");
//	          try {
//	              BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
//	              FileInputStream fis = new FileInputStream(folderPath+fileName);
//	              int len;
//	              byte[] buf = new byte[1024];
//	              while((len = fis.read(buf)) > 0) {
//	                  bos.write(buf,0,len);
//	              }
//	              bos.close();
//	              response.flushBuffer();
//	          }
//	          catch(IOException e) {
//	              e.printStackTrace();
//
//	          }
//	    }
//	    
//	    
//	    ///
//	    
//	    @ResponseBody
//	    @RequestMapping(value = "/Image/{id:.+}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.IMAGE_JPEG_VALUE)
//	    public ResponseEntity<byte[]> getImage(@PathVariable("id")String id) {
//	        byte[] image = imageService.getImage(id);  //this just gets the data from a database
//	        return ResponseEntity.ok(image);
//	    }
//	    
//	    Code after comments (set content type, take out produces):
//
//	    	@RequestMapping(value = "/Image/{id:.+}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
//	    	public ResponseEntity<byte[]> getImage(@PathVariable("id")String id, HttpServletResponse response) {
//	    	    byte[] image = imageService.getImage(id);  //this just gets the data from a database
//	    	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//	    	    return ResponseEntity.ok(image);
//	    	}
//	    	
//	    	// solution
//	    	
//	    	@RequestMapping(value = "/Image/{id:.+}", method = RequestMethod.GET)
//	    	public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
//	    	    byte[] image = imageService.getImage(id);
//	    	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
//	    	}

}
