package core.basesyntax;

/**
 * <p>Дан класс Rectangle. Переопределите в нем методы equals() и hashCode() так, чтобы equals()
 * сравнивал экземпляры Rectangle по содержимому полей color, width и length,
 * а hashCode() был бы согласованным с реализацией equals().</p>
 */
public class Rectangle {
    private Integer width;
    private Integer length;
    private String color;

    public Rectangle(Integer width, Integer length, String color) {
        this.width = width;
        this.length = length;
        this.color = color;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null) {
            return false;
        }

        if (object.getClass() == Rectangle.class) {
            Rectangle rectangle = (Rectangle) object;
            if (!this.hasAllEmptyParameters()
                    && !rectangle.hasAllEmptyParameters()) {
                return width.equals(rectangle.width)
                        && length.equals(rectangle.length)
                        && color.equals(rectangle.color);
            }
            return this.hasAllEmptyParameters()
                    && rectangle.hasAllEmptyParameters();
        }

        return false;
    }

    @Override
    public int hashCode() {
        if (width != null && length != null && color != null) {
            int hashCode = 17;
            hashCode = 31 * hashCode + width.hashCode();
            hashCode = 31 * hashCode + length.hashCode();
            hashCode = 31 * hashCode + color.hashCode();
            return hashCode;
        }
        return 0;
    }

    public boolean hasAllEmptyParameters() {
        return width == null && color == null && length == null;
    }
}
