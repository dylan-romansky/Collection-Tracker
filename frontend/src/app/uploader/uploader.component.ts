import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-uploader',
  templateUrl: './uploader.component.html',
  styleUrls: ['./uploader.component.css']
})
export class UploaderComponent implements OnInit {

	filename = '';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  onFileSelected(event)	{
  	const file:File = event.target.files[0];
	if (file)	{
		this.filename = file.name;
		const formData = new FormData();
		formData.append(filename, file);
		const upload$ = this.http.post("http://localhost:8080/img/create", formData);
		upload$.subscribe();
	}
  }

}
