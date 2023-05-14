package src.main.java.com.tracejp.bingochart.server.entity;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/12 9:02
 */
public class FontConfigEntity {

    private Integer size;

    private Integer style;

    private Integer color;

    public FontConfigEntity() {
    }

    public FontConfigEntity(Integer size, Integer style, Integer color) {
        this.size = size;
        this.style = style;
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

}
