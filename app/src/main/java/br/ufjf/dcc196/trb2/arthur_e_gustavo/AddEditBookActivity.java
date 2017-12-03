package br.ufjf.dcc196.trb2.arthur_e_gustavo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

import br.ufjf.dcc196.trb2.arthur_e_gustavo.adapters.BookAdapter;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.helpers.BookHelper;
import br.ufjf.dcc196.trb2.arthur_e_gustavo.models.Book;

public class AddEditBookActivity extends AppCompatActivity {

    private ListView listBooks;
    private BookAdapter bookAdapter;
    private Button btnAdd;
    private Button btnBack;
    private EditText edtTitle;
    private EditText edtPublisher;
    private EditText edtYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_book);

        btnAdd = (Button) findViewById(R.id.btnAddBook);
        btnBack = (Button) findViewById(R.id.btnBackBook);

        edtTitle = (EditText) findViewById(R.id.edtBookTitle);
        edtPublisher = (EditText) findViewById(R.id.edtBookPublisher);
        edtYear = (EditText) findViewById(R.id.edtBookYear);

        listBooks = (ListView) findViewById(R.id.listBook);
        bookAdapter = new BookAdapter(getApplicationContext(), new BookHelper(getApplicationContext()).getAllCursor());
        listBooks.setAdapter(bookAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean error = false;
                if (edtTitle.getText().toString().isEmpty()) {
                    edtTitle.setError(getResources().getString(R.string.edt_title_empty));
                    edtTitle.requestFocus();
                    error = true;
                }
                if (edtPublisher.getText().toString().isEmpty()) {
                    edtPublisher.setError(getResources().getString(R.string.edt_publisher_empty));
                    edtPublisher.requestFocus();
                    error = true;
                }
                if (edtYear.getText().toString().isEmpty()) {
                    edtYear.setError(getResources().getString(R.string.edt_year_empty));
                    edtYear.requestFocus();
                    error = true;
                } else if (Integer.parseInt(edtYear.getText().toString()) > Calendar.getInstance().get(Calendar.YEAR)) {
                    edtYear.setError(getResources().getString(R.string.edt_year_over));
                    edtYear.requestFocus();
                    edtYear.selectAll();
                    error = true;
                }

                if (!error) {
                    Book book = new Book(edtTitle.getText().toString(), edtPublisher.getText().toString(), Integer.parseInt(edtYear.getText().toString()));
                    new BookHelper(getApplicationContext()).add(book);
                    Toast.makeText(AddEditBookActivity.this, getResources().getString(R.string.successfully_registered), Toast.LENGTH_LONG).show();
                    edtTitle.setText("");
                    edtPublisher.setText("");
                    edtYear.setText("");
                    edtTitle.requestFocus();
                    bookAdapter.changeCursor(new BookHelper(getApplicationContext()).getAllCursor());
                }
            }
        });

        listBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AddEditBookActivity.this, DetailsBookActivity.class);
                intent.putExtra("book", id);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
