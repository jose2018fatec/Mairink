package swing;



import javax.swing.Icon;
import javax.swing.JFrame;

/**
 *
 * @author Jose
 */
public class JImageFrame extends JFrame {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public JImageFrame() {
        super();
        setContentPane(new JImagePanel());
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public JImageFrame(Icon backgroundImage) {
        super();
        ((JImagePanel) getContentPane()).setBackgroundImage(backgroundImage);
    }

    public Icon getBackgroundImage() {
        return ((JImagePanel) getContentPane()).getBackgroundImage();
    }

    public void setBackgroundImage(Icon backgroundImage) {
        ((JImagePanel) getContentPane()).setBackgroundImage(backgroundImage);
    }

    public void updateBackgroundImage() {
        ((JImagePanel) getContentPane()).updateBackgroundImage();
    }

} // Fim da classe JImageFrame
