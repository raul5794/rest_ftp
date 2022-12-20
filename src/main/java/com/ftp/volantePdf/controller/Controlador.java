package com.ftp.volantePdf.controller;

import com.ftp.volantePdf.service.FtpService;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class Controlador {

    @Autowired
    FtpService ftpService;

    /*@RequestMapping("/conectar")
    public byte[] conectar() throws Exception {
        FTPClient ftpClient= ftpService.loginFTP("ftp.incalines.com",21,"shohin_ftp@incalines.net","Sh0hin@2022++");
       // FTPClient ftpClient= ftpService.loginFTP("192.168.10.14",21,"Usuario","12345");
    // ftpService.createDirectory("/1234",ftpClient);
    // ftpService.uploadFile("D:\\PRUEBA_1.pdf","PRUEBA_1.pdf",ftpClient);
    // ftpService.deleteDirectory("/123456",ftpClient);
    //  ftpService.desconectar(ftpClient);
      byte[] bt = ftpService.downloadFile("prueba3.pdf",ftpClient);
      InputStream inputStream = new ByteArrayInputStream(bt);
      Files.copy(inputStream,Paths.get("D:\\prueba3.pdf"),StandardCopyOption.REPLACE_EXISTING);
      return bt;
    }

    @RequestMapping("/conectar2")
    public void conectar2() throws Exception {
        FTPClient ftpClient= ftpService.loginFTP("192.168.10.14",21,"Usuario","12345");

        // ftpService.createDirectory("/1234",ftpClient);
   ftpService.uploadFile("D:\\prueba2.pdf","prueba2.pdf",ftpClient);
        // ftpService.deleteDirectory("/123456",ftpClient);
        //  ftpService.desconectar(ftpClient);

    }*/

  /*  @GetMapping("/cargarpdf/{id}")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile multipartFile, @PathVariable String id)
            throws Exception {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Long size = multipartFile.getSize();
        byte [] byArr = multipartFile.getBytes();
        InputStream inputStream = new ByteArrayInputStream(byArr);
        //FTPClient ftpClient= ftpService.loginFTP("ftp.incalines.com",21,"shohin_ftp@incalines.net","Sh0hin@2022++");
        FTPClient ftpClient= ftpService.loginFTP("192.168.10.14",21,"Usuario","12345");
        ftpService.uploadFile2(inputStream,id+".pdf",ftpClient);
        return new ResponseEntity<>("Cargado y Subido", HttpStatus.OK);
    }

   @PostMapping("/pdf/{id}")
    public ResponseEntity<String> uploadFile2(
            @RequestParam("file") byte[] bt,@PathVariable String id)
            throws Exception {
        byte [] byArr = bt;
        InputStream inputStream = new ByteArrayInputStream(byArr);
        //FTPClient ftpClient= ftpService.loginFTP("ftp.incalines.com",21,"shohin_ftp@incalines.net","Sh0hin@2022++");
        FTPClient ftpClient= ftpService.loginFTP("192.168.10.14",21,"Usuario","12345");
        ftpService.uploadFile2(inputStream,id+".pdf",ftpClient);
        return new ResponseEntity<>("Cargado y Subido", HttpStatus.OK);
    }*/

    @PostMapping("/body/{id}")
    public ResponseEntity<String> uploadFile3(
            @RequestBody byte[] bt,@PathVariable String id)
            throws Exception {
        byte [] byArr = bt;
        InputStream inputStream = new ByteArrayInputStream(byArr);
        FTPClient ftpClient= ftpService.loginFTP("ftp.incalines.com",21,"shohin_ftp@incalines.net","Sh0hin@2022++");
        //FTPClient ftpClient= ftpService.loginFTP("192.168.10.14",21,"Usuario","12345");
        ftpService.uploadFile2(inputStream,id+".pdf",ftpClient);
        return new ResponseEntity<>("Cargado y Subido", HttpStatus.OK);
    }

}
