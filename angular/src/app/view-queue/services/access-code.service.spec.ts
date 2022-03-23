import { HttpClientTestingModule } from "@angular/common/http/testing";
import { TestBed } from "@angular/core/testing";
import { RouterTestingModule } from "@angular/router/testing";
import { AccessCodeService } from "./access-code.service";

describe("AccessCodeService", () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule],
    })
  );

  it("should be created", () => {
    const service: AccessCodeService = TestBed.inject(AccessCodeService);
    expect(service).toBeTruthy();
  });
});
