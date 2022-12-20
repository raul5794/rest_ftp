package com.ftp.volantePdf.service;
import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class FtpService {

    public FTPClient loginFTP(String host,int port, String userName,String password) throws Exception{
        FTPClient ftpClient = new FTPClient();
        ftpClient.addProtocolCommandListener(new ProtocolCommandListener() {
            @Override
            public void protocolCommandSent(ProtocolCommandEvent protocolCommandEvent) {
                System.out.printf("[%s][%d] Command sent : [%s]-%s", Thread.currentThread().getName(),
                        System.currentTimeMillis(), protocolCommandEvent.getCommand(),
                        protocolCommandEvent.getMessage());
            }

            @Override
            public void protocolReplyReceived(ProtocolCommandEvent protocolCommandEvent) {
                System.out.printf("[%s][%d] Reply received : %s", Thread.currentThread().getName(),
                        System.currentTimeMillis(), protocolCommandEvent.getMessage());
            }
        });
        ftpClient.connect(host, port);
        ftpClient.login(userName, password);
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        return ftpClient;
    }
    public void createDirectory(String path, FTPClient ftpClient) throws Exception {
        System.out.printf("[createDirectory][%d] Is success to create directory : %s -> %b",
        System.currentTimeMillis(), path, ftpClient.makeDirectory(path));
        System.out.println();
    }

    public void uploadFile(String localPath, String remotePath, FTPClient ftpClient) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(localPath);
        System.out.println();
        System.out.printf("[uploadFile][%d] Is success to upload file : %s -> %b",
                System.currentTimeMillis(), remotePath, ftpClient.storeFile(remotePath, fileInputStream));
        System.out.println();
    }

    public void uploadFile2(InputStream inputStream, String remotePath, FTPClient ftpClient) throws Exception {

        System.out.println();
        System.out.printf("[uploadFile][%d] Is success to upload file : %s -> %b",
                System.currentTimeMillis(), remotePath, ftpClient.storeFile(remotePath, inputStream));
        System.out.println();
    }

        public void deleteDirectory(String path, FTPClient ftpClient) throws Exception {
        System.out.println();
        System.out.printf("[deleteDirectory][%d] Is success to delete directory : %s -> %b",
                System.currentTimeMillis(), path, ftpClient.removeDirectory(path));
        System.out.println();
    }
    public byte[] downloadFile(String path, FTPClient ftpClient) throws Exception {
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.out.println();
        System.out.printf("[downloadFile][%d] Is success to download file : %s -> %b",
                System.currentTimeMillis(), path, ftpClient.retrieveFile(path, byteArrayOutputStream));
        System.out.println();
        return byteArrayOutputStream.toByteArray();
    }
    public void desconectar(FTPClient ftp) throws Exception{
        ftp.disconnect();
    }
    }


