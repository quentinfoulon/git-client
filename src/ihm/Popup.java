package ihm;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Popup {

	protected Shell shell;
	private static String message;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void main2(String s) {
		message=s;
		try {
			Popup window = new Popup();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(366, 154);
		shell.setText("Information");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(10, 31, 328, 20);
		lblNewLabel.setText(message);
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnOk.setBounds(118, 67, 90, 30);
		btnOk.setText("ok");

	}

}
