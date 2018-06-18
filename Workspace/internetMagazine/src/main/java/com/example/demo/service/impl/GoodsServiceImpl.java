package com.example.demo.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.Base64MultipatrFile;
import com.example.demo.entity.Category;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Image;
import com.example.demo.entity.Marka;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.GoodsRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.MarkaRepository;
import com.example.demo.request.FindOneCategoryRequest;
import com.example.demo.request.GoodsRequest;
import com.example.demo.responce.GoodsResponce;
import com.example.demo.responce.MarkaResponce;
import com.example.demo.service.GoodsService;

import sun.misc.BASE64Decoder;

@Service
public class GoodsServiceImpl implements GoodsService {

	private final static String PATH = "C:/Users/Mik/Desktop/ProjectWork/Web/image";
	private final static String PATH1 = "file:///C:/Users/Mik/Desktop/ProjectWork/Web/";
	
	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private MarkaRepository markaRepository;	
	
	@Override
	public void save(Goods goods) {
		goodsRepository.save(goods);		
	}

	@Override
	public Goods findOne(long id) {
		return goodsRepository.findOne(id);
	}

	@Override
	public List<Goods> findAll() {
		return goodsRepository.findAll();
	}
	
	@Override
	public Goods createGoods(GoodsRequest goodsRequest) throws IOException {
		byte[]fileContent;
		BASE64Decoder decoder = new BASE64Decoder();
		fileContent = decoder.decodeBuffer(goodsRequest.getImageName().split(",")[1]);
		String expansion = goodsRequest.getImageName().split(",")[0].split("/")[1].split(";")[0];
		goodsRequest.setImageName(null);	
		List<Image> findAll = imageRepository.findAll();
		long list = findAll.size();		
		Base64MultipatrFile multipartFile = new Base64MultipatrFile(fileContent, list+"."+expansion);
		saveFile(multipartFile);
		Image image = new Image("/image/"+list+"."+expansion);
		imageRepository.saveAndFlush(image);
		Category findCategory = categoryRepository.findOne(goodsRequest.getCategoryId());
		Marka findMarka = markaRepository.findOne(goodsRequest.getMarka());
		Goods goods = new Goods(findMarka, goodsRequest.getPrice(),goodsRequest.getModel(), findCategory, image);
		imageRepository.save(image);
		goodsRepository.save(goods);
		return goodsRepository.save(goods);
	}
	private void saveFile(MultipartFile file) throws FileNotFoundException, IOException {
		File pathToFolder = new File(PATH);
		createFolder(pathToFolder);
		File newFile = new File(pathToFolder+"/"+file.getOriginalFilename());
		writeFile(newFile, file);
	}
	private void createFolder(File path) {
		if(!path.exists()) {
			path.mkdirs();
		}
	}
	private void writeFile(File file, MultipartFile multipartFile) throws FileNotFoundException, IOException {
		try(OutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos)){
			bos.write(multipartFile.getBytes(),0,multipartFile.getBytes().length);
			bos.flush();
		}catch(IOException e){
			
		}
	}

	private GoodsResponce convert(Goods goods) {
		return new GoodsResponce(goods);		
	}
	
	@Override
	public Map<Integer,GoodsResponce> findAllGoodsTwo() {
		List<Goods> findAll = goodsRepository.findAll();
		Map<Integer,GoodsResponce> us = new HashMap<>();
		for (Goods goods : findAll) {
		GoodsResponce response = convert(goods);
		response.setImage(PATH1+response.getImage());
		us.put((int) response.getId(), response);
	}
		return us;
}
	@Override
	public void delete(long id) {
		goodsRepository.delete(id);
	}

	@Override
	public boolean deleteGoods(long id) {
		goodsRepository.delete(id);
		return true;
	}
	@Override
	public Goods update	(GoodsRequest goodsRequest) {
		Goods goods = goodsRepository.findOne(goodsRequest.getId());
		goods.setModel(goodsRequest.getModel());
		goods.setPrice(goodsRequest.getPrice());
		return goodsRepository.save(goods);
				
	}
	@Override
	public Map<Integer,GoodsResponce> findAllGoodsByCategory(long id) {
		List<Goods> findAll = goodsRepository.findGoodsByCategoryId(id);
		Map<Integer,GoodsResponce> us = new HashMap<>();
		for (Goods goods : findAll) {
		GoodsResponce response = convert(goods);
		response.setImage(PATH1+response.getImage());
		us.put((int) response.getId(), response);
	}
		return us;
}

	@Override
	public Map<Integer, GoodsResponce> findAllGoodsByMarka(long idMarka) {
		List<Goods> findAll = goodsRepository.findGoodsByMarkaId(idMarka);
		Map<Integer,GoodsResponce> us = new HashMap<>();
		for (Goods goods : findAll) {
		GoodsResponce response = convert(goods);
		response.setImage(PATH1+response.getImage());
		us.put((int) response.getId(), response);
	}
		return us;
}
}
