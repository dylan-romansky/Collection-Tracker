import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-uploader',
  templateUrl: './uploader.component.html',
  styleUrls: ['./uploader.component.css']
})
export class UploaderComponent implements OnInit {

  filename = '';
  entryform: FormGroup = this.fb.group({
    name: ['', [Validators.required]],
    description: '',
	imageId: ''
    });

  constructor(private http: HttpClient, private fb: FormBuilder) { }

  ngOnInit(): void {
  }

  onFileSelected(event:any)	{
  	const file:File = event.target.files[0];
	if (file)	{
		this.filename = file.name;
		const formData = new FormData();
		formData.append(this.filename, file);
		const upload$ = this.http.post("http://localhost:8080/img/create", formData);
		upload$.subscribe();
	}
  }

}
