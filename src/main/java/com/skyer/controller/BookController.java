package com.skyer.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skyer.enumerate.ResultEnum;
import com.skyer.service.BookService;
import com.skyer.util.Config;
import com.skyer.vo.Book;

/**
 * 图书控制器
 * 
 * @author Zongqian
 */
@Controller
@RequestMapping("/book")
public class BookController extends BaseController {

	private final static Logger L = Logger.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Object findAll() {
		try {
			List<Map<String, Object>> list = bookService.findAll();
			return super.success(list);
		} catch (Exception e) {
			L.error("--------------------------", e);
			e.printStackTrace();
		}
		return super.fail(ResultEnum.SEARCH_ERROR.getCode(), ResultEnum.SEARCH_ERROR.getValue());
	}

	/**
	 * 添加图书
	 * 
	 * @param book
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Object add(Book book) {
		try {
			boolean flag = bookService.add(book);
			if (flag) {
				return super.success("添加成功！");
			}
		} catch (Exception e) {
			L.error("--------------------------", e);
			e.printStackTrace();
		}
		return super.fail(ResultEnum.HANDLE_ERROR.getCode(), ResultEnum.HANDLE_ERROR.getValue());
	}

	/**
	 * 上传封面图
	 * 
	 * @return
	 */
	@RequestMapping("/uploadImage")
	@ResponseBody
	public Object uploadImage(HttpServletRequest req, HttpServletResponse resp) {
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024 * 1024 * 20);
			File folder = new File(Config.getImageUploadPath() + "tmp");
			if (!folder.exists()) {
				folder.mkdirs();
			}
			factory.setRepository(folder);
			ServletFileUpload upload = new ServletFileUpload(factory);

			upload.setSizeMax(1024 * 1024 * 50);
			List<FileItem> items = upload.parseRequest(req);

			FileItem fileItem = null;
			@SuppressWarnings("unused")
			String definition = "";
			for (Iterator<FileItem> it = items.iterator(); it.hasNext();) {
				FileItem item = (FileItem) it.next();
				if (item.getFieldName().equals("book_image")) {
					fileItem = item;
				}
			}
			InputStream in = fileItem.getInputStream();
			String fileName = fileItem.getName();
			// 保存
			if (fileName.equals("")) {
				return super.fail(ResultEnum.HANDLE_ERROR.getCode(), ResultEnum.HANDLE_ERROR.getValue());
			}
			fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."), fileName.length());
			String folderPath = Config.getImageUploadPath();
			folder = new File(folderPath);

			if (!folder.exists()) {
				folder.mkdirs();
			}
			// 保存
			File saveFile = new File(folder, fileName);
			FileOutputStream fos = new FileOutputStream(saveFile);
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = in.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			fos.close();
			in.close();
			return super.success(Config.getImageUrl() + fileName);
		} catch (Exception e) {
			L.error("--------------------------", e);
			e.printStackTrace();
		}
		return super.fail(ResultEnum.HANDLE_ERROR.getCode(), ResultEnum.HANDLE_ERROR.getValue());
	}

	/**
	 * 打开一本图书
	 * 
	 * @param id 图书ID
	 * @return
	 */
	@RequestMapping("/findById")
	public ModelAndView findById(String id, HttpServletRequest req) {
		try {
			Book book = bookService.findById(id);
			ModelAndView mv = new ModelAndView("view/book/detail");
			mv.addObject("book", book);
			return mv;
		} catch (Exception e) {
			L.error("--------------------------", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取表格数据
	 * 
	 * @return
	 */
	@RequestMapping("/getChartsInfo")
	@ResponseBody
	public Object getChartsInfo() {
		try {
			List<Map<String, Object>> list = bookService.getNumberInfo();
			return super.success(list);
		} catch (Exception e) {
			L.error("--------------------------", e);
			e.printStackTrace();
		}
		return super.fail(ResultEnum.SEARCH_ERROR.getCode(), ResultEnum.SEARCH_ERROR.getValue());
	}

}
