resource "azurerm_public_ip" "vm_pip" {
  for_each            = var.vms

  name                = "vm-pip-${each.value.name}"
  resource_group_name = azurerm_resource_group.rg.name
  location            = azurerm_resource_group.rg.location
  allocation_method   = "Dynamic"
}

resource "azurerm_network_interface" "vm_nic" {
  for_each            = var.vms

  name                = "vm-nic-${each.value.name}"
  location            = azurerm_resource_group.rg.location
  resource_group_name = azurerm_resource_group.rg.name

  ip_configuration {
    name                          = "internal"
    subnet_id                     = azurerm_subnet.subnet.id
    private_ip_address_allocation = "Dynamic"
    public_ip_address_id          = azurerm_public_ip.vm_pip[each.value.name].id
  }
}

resource "azurerm_linux_virtual_machine" "vm" {
  for_each            = var.vms 

  name                = "vm-${each.value.name}"
  resource_group_name = azurerm_resource_group.rg.name
  location            = azurerm_resource_group.rg.location
  size                = each.value.size
  admin_username      = "adminuser"
  network_interface_ids = [
    azurerm_network_interface.vm_nic[each.value.name].id,
  ]
  disable_password_authentication = false
  admin_password                  = "i#n*#@b4jwvirnnNUH(#HInK"

  custom_data = base64encode(file("${path.module}/customdata.sh"))

  os_disk {
    caching              = "ReadWrite"
    storage_account_type = "Standard_LRS"
  }

  source_image_reference {
    publisher = "Canonical"
    offer     = "UbuntuServer"
    sku       = "18.04-LTS"
    version   = "latest"
  }
}