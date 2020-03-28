package designMode.bridgepatternExample;

public abstract class Image {
    protected ImageImp imageImp;

    public void setImageImp(ImageImp imageImp) {
        this.imageImp = imageImp;
    }

    abstract void parseFile(String fileName);
}
