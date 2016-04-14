package cc.firstTest.domain;

/**
 * Created by cheng on 2016/1/9 0009.
 */
public class FileUploadInfo {


    private static   FileUploadInfo fileUploadInfo;

    Long pBytesRead;

    Long pContentLength;

    Integer pItems;

    Integer persent;

    Double totalSize;

    Double currentSize;

    Double speed;

    Long startTime;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public FileUploadInfo getFileUploadInfo() {
        return fileUploadInfo;
    }

    public void setFileUploadInfo(FileUploadInfo fileUploadInfo) {
        this.fileUploadInfo = fileUploadInfo;
    }

    public Integer getPersent() {
        return persent;
    }

    public void setPersent(Integer persent) {
        this.persent = persent;
    }

    public Double getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Double totalSize) {
        this.totalSize = totalSize;
    }

    public Double getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Double currentSize) {
        this.currentSize = currentSize;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public static   FileUploadInfo getIstance(){
        if (fileUploadInfo==null){
            return  new FileUploadInfo();
        }
        return fileUploadInfo;
    }




    private FileUploadInfo() {

        this.pBytesRead=0L;
        this.pContentLength=0L;
    }

    public Long getpBytesRead() {
        return pBytesRead;
    }

    public void setpBytesRead(Long pBytesRead) {
        this.pBytesRead = pBytesRead;
    }

    public Long getpContentLength() {
        return pContentLength;
    }

    public void setpContentLength(Long pContentLength) {
        this.pContentLength = pContentLength;
    }

    public Integer getpItems() {
        return pItems;
    }

    public void setpItems(Integer pItems) {
        this.pItems = pItems;
    }


    public  static  void  main(String[] args){
        System.out.print("123");
    }
}
