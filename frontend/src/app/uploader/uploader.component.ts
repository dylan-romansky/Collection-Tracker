import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-uploader',
  templateUrl: './uploader.component.html',
  styleUrls: ['./uploader.component.css']
})
export class UploaderComponent implements OnInit {

  EQPURL: string = "http://localhost:8080/eqp";
  IMGURL: string = "http://localhost:8080/img";
  filename = '';
  entryform: FormGroup = this.fb.group({
    name: ['', [Validators.required]],
    description: '',
	imageId: ''
    });

  constructor(private http: HttpClient, private fb: FormBuilder) { }

  ngOnInit(): void {
  }

  submitHandler()  {
    var formdata: any = new FormData();
	formdata.append("name", this.entryform.get("name")!.value);
	formdata.append("description", this.entryform.get("description")!.value);
	formdata.append("imageId", this.entryform.get("imageId"));
	this.http.post(this.EQPURL + '/create', formdata).subscribe(
	  (response) => console.log(response),
	  (error) => console.log(error)
	)
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
