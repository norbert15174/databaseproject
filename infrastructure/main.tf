terraform {
  required_providers {
    azurerm = {
      source = "hashicorp/azurerm"
      version = "3.31.0"
    }
  }
  backend "azurerm" {
    resource_group_name  = "tfstate"
    storage_account_name = "databasetfstate"
    container_name       = "tfstate"
    key                  = "database.tfstate"
  }
}


provider "azurerm" {
  features {}
}