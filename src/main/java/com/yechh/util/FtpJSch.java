package com.yechh.util;
/**
 * @author ：yechh
 * @date ：Created in 2019/4/28 10:31
 * @description：
 * @modified By：
 * @version: v1.0
 */

import com.jcraft.jsch.*;
import com.yechh.domain.Ftp;

import java.io.*;
import java.util.Properties;
import java.util.Vector;

public class FtpJSch {

    private static ChannelSftp sftp = null;
    private static ChannelExec execChannel=null;
    private static Session sshSession=null;

    public static FtpJSch getConnect(Ftp ftp){
        FtpJSch ftpJSch = new FtpJSch();
        try {
            JSch jsch = new JSch();

            //获取sshSession  账号-ip-端口
            sshSession =jsch.getSession(ftp.getUser(), ftp.getHost(),ftp.getPort());
            //添加密码
            sshSession.setPassword(ftp.getPassword());
            Properties sshConfig = new Properties();
            //严格主机密钥检查
            sshConfig.put("StrictHostKeyChecking", "no");

            sshSession.setConfig(sshConfig);
            //开启sshSession链接
            sshSession.connect();
            //获取sftp通道
            Channel channel = sshSession.openChannel("sftp");
            //开启
            channel.connect();
            sftp = (ChannelSftp) channel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ftpJSch;
    }

    /**
     *
     * @param uploadFile 上传文件的路径
     * @return 服务器上文件名
     */
    public String upload(String uploadFile,String directory,String fileName) {
        File file = null;
        //String fileName = null;
        try {
            sftp.cd(directory);
            file = new File(uploadFile);
            //获取随机文件名
            //fileName  = UUID.randomUUID().toString() + file.getName().substring(file.getName().length()-5);
            //文件名是 随机数加文件名的后5位
            sftp.put(new FileInputStream(file), fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file == null ? null : fileName+"    上传"+directory+"成功"+"/n";
    }

    /**
     * create by: yechh
     * description: 执行shell命令
     * create time: 2019/4/29 14:06
     * @return
     */
    public String exec(String command){

        String result = "";
        try {
            //获取exec通道
            execChannel=(ChannelExec)sshSession.openChannel("exec");
            execChannel.setCommand(command);
            int exitStatus = execChannel.getExitStatus();
            result+="执行的命令为："+command+"/n";
            result+="执行的状态为："+exitStatus+"/n";
            execChannel.connect();
            InputStream in = execChannel.getInputStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in));
            String buf = null;
            while ((buf = reader.readLine()) != null) {
                result += " " + buf+"/n";
            }
        }catch (Exception e){
            result += e.getMessage();
        }finally {
            execChannel.disconnect();
        }
        return result;

    }
    /**
     * create by: yechh
     * description: 关闭sftp连接
     * create time: 2019/4/29 9:25
     * @return
     */
    public  void disconnect(){
         if(sftp!=null){
             sftp.disconnect();
         }
         if(execChannel!=null){
             execChannel.disconnect();
         }if(sshSession!=null){
            sshSession.disconnect();
        }
    }

    /**
     * 下载文件
     *
     * @param directory
     *            下载目录
     * @param saveFile
     *            存在本地的路径
     * @param
     */
    public void download(String downloadFileName,String directory,String saveFile) {
        try {
            sftp.cd(directory);
            File file = new File(saveFile);
            sftp.get(downloadFileName, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     *
     * @param deleteFile
     *            要删除的文件名字
     * @param
     */
    public void delete(String deleteFile,String directory) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 列出目录下的文件
     *
     * @param directory
     *            要列出的目录
     * @param directory
     * @return
     * @throws SftpException
     */
    public Vector listFiles(String directory)
            throws SftpException {
        return sftp.ls(directory);
    }


}

