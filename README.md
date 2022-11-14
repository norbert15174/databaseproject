# DATABASE PROJECT
## 1. Requirements
* az cli (https://learn.microsoft.com/en-us/cli/azure/install-azure-cli)
* terraform (https://www.terraform.io/)

## 2. Infrastructure
If you want to create VMs, enter the following command to your teraminal:
* ```az login```
* ```cd infrastructure```
* ```terraform init```
* ```terraform apply -var-file variables.tfvars --auto-approve```