package src.main.java.com.tracejp.bingochart.server.entity;

import java.awt.*;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/12 9:02
 */
public class FontConfigEntity {

    private Integer size;

    private String style;

    private Color color;

    public FontConfigEntity() {
    }

    public FontConfigEntity(Integer size, String style, Color color) {
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
