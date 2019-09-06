package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText number_input;
	private int n,convertNumber;
	private Random rand;
	private Button guess_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		number_input = findViewById(R.id.number_input);
		guess_button = findViewById(R.id.guess_button);
		rand = new Random();
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		n = rand.nextInt(100)+1;
	}

	public void handleGuess(View view) {
		String num = number_input.getText().toString();
		if (num.equalsIgnoreCase("")) {
			Toast.makeText(this, "Harap Mengisi Angka!!", Toast.LENGTH_SHORT).show();
		}else {
			convertNumber = Integer.parseInt(num);
			if (convertNumber == n){
				Toast.makeText(this, "Tebakan anda benar!",Toast.LENGTH_SHORT).show();
				guess_button.setEnabled(false);
			}else if (convertNumber > n) {
				Toast.makeText(this, "Tebakan anda terlalu besar!",Toast.LENGTH_SHORT).show();
			}else {
				Toast.makeText(this, "Tebakan anda terlalu kecil!",Toast.LENGTH_SHORT).show();
			}
		}
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		number_input.setText("");
		initRandomNumber();
		guess_button.setEnabled(true);
	}
}
