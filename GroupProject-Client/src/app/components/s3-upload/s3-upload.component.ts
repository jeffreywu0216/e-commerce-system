// import { Component, OnInit } from '@angular/core';
// import { Credentials, S3 } from 'aws-sdk';
//
// @Component({
//   selector: 'app-s3-upload',
//   templateUrl: './s3-upload.component.html',
//   styleUrls: ['./s3-upload.component.css']
// })
// export class S3UploadComponent implements OnInit {
//   // Replace the values with your own
//   private readonly _awsConfig = {
//     accessKeyId: "<your keyId>",
//     secretAccessKey: "<your secret>",
//     s3BucketRegion: "<your region>", // example: "us-west-2"
//     s3BucketName: "<your bucket>"    // example: "mycompany.testbucket"
//   };
//   private _awsCredentials: Credentials;
//   private _s3ClientConfig: S3.ClientConfiguration;
//   private _s3: S3;
//
//   uploadStatus = "(no upload yet)";
//   expectEndpoint: string;
//   actualEndpoint: string;
//
//   constructor() {
//     // Create an AWS S3 client
//     this._awsCredentials = new Credentials(this._awsConfig.accessKeyId, this._awsConfig.secretAccessKey);
//     this._s3ClientConfig = {
//       credentials: this._awsCredentials,
//       region: this._awsConfig.s3BucketRegion,
//       sslEnabled: true
//     };
//     this._s3 = new S3(this._s3ClientConfig);
//
//     // Set the expected and actual endpoints
//     const isRegionUSEast: boolean = (this._awsConfig.s3BucketRegion).toLowerCase() === "us-east-1";
//     const endpointHost: string = isRegionUSEast ? "s3" : "s3-" + this._awsConfig.s3BucketRegion;
//     this.expectEndpoint = endpointHost + ".amazonaws.com";
//     this.actualEndpoint = this._s3.config.endpoint;
//   }
//
//   ngOnInit() {
//   }
//   fileEvent(fileInput: any) {
//     this.uploadStatus = "starting upload...";
//
//     // get the file to upload
//     const file: File = fileInput.target.files[0];
//     console.log(file);
//
//     // upload file to S3
//     const putObjectRequest: S3.PutObjectRequest = {
//       Key: 'categories/' + file.name,
//       Body: file,
//       Bucket: this._awsConfig.s3BucketName,
//       ContentType: file.type,
//       ServerSideEncryption: "AES256"
//     };
//
//     // use "that" to be able to reach component properties within the then/catch callback functions
//     const that = this;
//
//     // upload to S3
//     this._s3.upload(putObjectRequest).promise()
//       .then(function (response: S3.ManagedUpload.SendData) {
//         that.uploadStatus = "Success!\n File URI: " + response.Location;
//         // alert("upload successful!");
//       })
//       .catch(function (err: Error) {
//         let errMsg = "";
//         errMsg += "upload failed.\n ";
//         errMsg += "Error Message: " + err.message + "\n ";
//         errMsg += "NOTE: an error message of 'Network Failure' may mean that you have the wrong region or the wrong bucket name.";
//         that.uploadStatus = errMsg;
//         // alert(errMsg);
//       });
//   }
// }
//
