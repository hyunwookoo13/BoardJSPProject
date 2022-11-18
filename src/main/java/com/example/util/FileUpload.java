package com.example.common;

import com.example.bean.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;

public class FileUpload {
    public BoardVO uploadPhoto(HttpServletRequest  request){
        String filename="";
        int sizeLimit = 15*1024*1024;

        String realPath = request.getServletContext().getRealPath("upload");

        File dir = new File(realPath);
        if(!dir.exists()) dir.mkdirs();

        BoardVO one = null;
        MultipartRequest multipartRequest = null;
        try{
            multipartRequest = new MultipartRequest(request,realPath,sizeLimit,"utf-8",new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("photo");

            one = new BoardVO();
            String sid = multipartRequest.getParameter("sid");
            if(sid!=null&&!sid.equals("")) one.setSid(Integer.parseInt(sid));
            one.setCategory(multipartRequest.getParameter("category"));
            one.setCategory(multipartRequest.getParameter("category"));
            one.setCategory(multipartRequest.getParameter("category"));
            one.setCategory(multipartRequest.getParameter("category"));
            one.setCategory(multipartRequest.getParameter("category"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return one;
    }
}
