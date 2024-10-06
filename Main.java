package uni.assign2;
import javax.swing.JOptionPane;
interface MyButton {
    void showButton();}
interface MyCheckbox {
    void showCheckbox();}
interface ThemeMaker {
    MyButton createButton();
    MyCheckbox createCheckbox();}
class LightBtn implements MyButton {
    @Override
    public void showButton() {
        JOptionPane.showMessageDialog(null, "This is a LightTheme Button");}}
class LightCheck implements MyCheckbox {
    @Override
    public void showCheckbox() {
        JOptionPane.showMessageDialog(null, "This is a LightTheme Checkbox");}}
class DarkBtn implements MyButton {
    @Override
    public void showButton() {
        JOptionPane.showMessageDialog(null, "This is a DarkTheme Button");}}
class DarkCheck implements MyCheckbox {
    @Override
    public void showCheckbox() {
        JOptionPane.showMessageDialog(null, "This is a Dark Theme Checkbox");}}
class LightThemeMaker implements ThemeMaker {
    @Override
    public MyButton createButton() {
        return new LightBtn();}
    @Override
    public MyCheckbox createCheckbox() {
        return new LightCheck();}}
class DarkThemeMaker implements ThemeMaker {
    @Override
    public MyButton createButton() {
        return new DarkBtn();}
    @Override
    public MyCheckbox createCheckbox() {
        return new DarkCheck();}}

public class Main {
    public static void main(String[] args) {
        String[] themeChoices = {"Light", "Dark"};
        String selectedTheme = (String) JOptionPane.showInputDialog(
                null,
                "Pick your theme:",
                "Theme Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                themeChoices,
                themeChoices[0]);
        if (selectedTheme == null) {
            JOptionPane.showMessageDialog(null, "Eroor");
            return;}
        ThemeMaker themeFactory;
        switch (selectedTheme.toLowerCase()) {
            case "light":
                themeFactory = new LightThemeMaker();
                break;
            case "dark":
                themeFactory = new DarkThemeMaker();
                break;
            default:
                throw new IllegalArgumentException("Unknown theme: " + selectedTheme);}
        MyButton button = themeFactory.createButton();
        MyCheckbox checkbox = themeFactory.createCheckbox();
        button.showButton();
        checkbox.showCheckbox();}}
